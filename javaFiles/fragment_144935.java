public class CustomJsonPropertySerializer extends JsonSerializer<Bar> {

    @Override
    public void serialize(Bar bar, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeStartObject();

        Field[] fields = bar.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Object value = null;

            try {
                value = field.get(bar);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            if (field.isAnnotationPresent(CustomJsonProperty.List.class)) {
                CustomJsonProperty[] properties = field.getAnnotation(CustomJsonProperty.List.class).value();
                CustomJsonProperty chosenProperty = null;

                for (CustomJsonProperty c : properties) {
                    if (c.format().equalsIgnoreCase(bar.getFormat())) {
                        chosenProperty = c;
                        break;
                    }
                }

                if (chosenProperty == null) {
                    //invalid format given, use first format then
                    chosenProperty = properties[0];
                }

                jsonGenerator.writeStringField(chosenProperty.propertyName(), value.toString());
            }
        }

        jsonGenerator.writeEndObject();
    }
}