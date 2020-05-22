try {

        MappingJsonFactory jsonFactory = new MappingJsonFactory();

        JsonParser jsonParser = jsonFactory.createParser(inputStream);

        JsonToken token = null;

        token = jsonParser.nextToken();

        StringBuffer buffer = new StringBuffer();

        do {

            if (token == JsonToken.START_OBJECT) {
                buffer.append("{");
            } else if (token == JsonToken.END_OBJECT) {
                buffer.append("}");
                System.out.println("Received chunk: " + buffer.toString());
                buffer.setLength(0);
            } else if (token == JsonToken.FIELD_NAME) {
                jsonParser.nextToken();
                buffer.append("\"" + jsonParser.getCurrentName() + "\":");
                buffer.append("\"" + jsonParser.getText() + "\":");
            } else if (token == JsonToken.VALUE_STRING) {
                buffer.append("\"" + jsonParser.getCurrentName() + "\":");
                buffer.append("\"" + jsonParser.getText() + "\":");
            }

            token = jsonParser.nextToken();

        } while (token != null);

    } catch (Throwable th) {
        th.printStackTrace();
    }