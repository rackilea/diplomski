public class FooDeserializer implements JsonDeserializer<Foo> {

    private static final Pattern PATTERN = Pattern.compile("\\$\\{(.*)\\}");
    private static Properties props;
    private static Map<Class, Converter> converterForClass = new HashMap<>();

    static {
        try {
            Resource resource = new ClassPathResource(String.format("/application-%s.properties", System.getProperty("spring.profiles.active")));
            props = PropertiesLoaderUtils.loadProperties(resource);

            converterForClass.put(Integer.TYPE, s -> Integer.parseInt(s.replace("\"", "")));
            converterForClass.put(Double.TYPE, s -> Double.parseDouble(s.replace("\"", "")));
            converterForClass.put(String.class, s -> s);
            converterForClass.put(Long.TYPE, s -> Long.parseLong(s.replace("\"", "")));
            converterForClass.put(Boolean.TYPE, s -> Boolean.parseBoolean(s.replace("\"", "")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Foo deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {


        Foo foo = new Foo();

        JsonObject jobject = (JsonObject) jsonElement;

        for (Entry entry : jobject.entrySet()) {
            Field field = searchField(entry.getKey().toString());
            if (field != null) {
                field.setAccessible(true);
                try {
                    Object r = converterForClass.get(field.getType()).convert(entry.getValue().toString());
                    field.set(foo, r);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return foo;

    }

    private Field searchField(String name) {
        Field[] fields = Foo.class.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(SerializedName.class)) {
                String value = field.getAnnotation(SerializedName.class).value();

                Matcher matcher = PATTERN.matcher(value);
                if (value.equals(name)) {
                    return field;
                } else if (matcher.find()) {
                    if (props.get(matcher.group(1)).equals(name)) {
                        return field;
                    }
                }
            } else {
                if (field.getName().equals(name)) {
                    return field;
                }
            }
        }

        return null;
    }