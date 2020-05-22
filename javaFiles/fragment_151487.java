public class FooSerializer implements JsonSerializer<Foo> {

    private static final Pattern PATTERN = Pattern.compile("\\$\\{(.*)\\}");
    private static Properties props;

    static {
        try {
            Resource resource = new ClassPathResource(String.format("/application-%s.properties", System.getProperty("spring.profiles.active")));
            props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public JsonElement serialize(Foo foo, Type type, JsonSerializationContext jsonSerializationContext) {

        Field[] fields = foo.getClass().getDeclaredFields();

        JsonObject object = new JsonObject();

        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            if (field.isAnnotationPresent(SerializedName.class)) {
                String value = field.getAnnotation(SerializedName.class).value();
                Matcher matcher = PATTERN.matcher(value);
                if (matcher.find()) {
                    name = props.get(matcher.group(1)).toString();
                } else {
                    name = value;
                }
            }
            try {
                if (field.get(foo) != null) {
                    object.addProperty(name, field.get(foo).toString());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return object;
    }
}