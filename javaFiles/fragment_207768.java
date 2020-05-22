@Override
public void serialize(List aList, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

    if (aList != null) {

        jsonGenerator.writeStartObject();

        for (int index = 0 ; index < aList.size(); index++) {

            try {

                Object next = aList.get(index);

                List<Field> fields = FieldUtils.getAllFieldsList(next.getClass());

                for (int j = 0 ; j < fields.size(); j ++ ) {

                    jsonGenerator.writeObjectField(String.format("%s[%s]",fields.get(j).getName(),index) , fields.get(j).get(next));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        jsonGenerator.writeEndObject();
    }
}