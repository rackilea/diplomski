JsonFactory factory = new JsonFactory();
String jsonString = "{\"name\":\"name\", \"score\":100, \"output\":[1,2],\"images\":[\"image1\",\"image2\"],\"description\":\"This is a description\"}";
JsonParser parser = factory.createParser(jsonString);
JsonToken token;
while ((token = parser.nextToken()) != JsonToken.END_OBJECT) {
    if (token == JsonToken.FIELD_NAME) {
        // Found name, lets read value
        System.out.print(parser.getCurrentName() + " = ");
        token = parser.nextToken();
        if (token == JsonToken.VALUE_STRING) {
            System.out.println(parser.getValueAsString());
        } else if (token == JsonToken.VALUE_NUMBER_INT) {
            System.out.println(parser.getValueAsInt());
        } else if (token == JsonToken.START_ARRAY) {
            // Found start array, lets read it all
            System.out.print("[");
            while (parser.nextToken() != JsonToken.END_ARRAY) {
                System.out.print(parser.getText() + ", ");
            }
            System.out.println("]");
        }
    }
}
parser.close();