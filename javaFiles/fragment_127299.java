ObjectMapper om = new ObjectMapper();
om.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

MyJson asString = om.readValue("{\n"
            + "  \"code\" : \"REQ500\",\n"
            + "  \"description\" : \"Problem with Service\",\n"
            + "  \"params\" : \"\"\n"
            + "}", MyError.class);

MyJson asArray = om.readValue("{\n"
            + "  \"code\" : \"REQ500\",\n"
            + "  \"description\" : \"Problem with Service\",\n"
            + "  \"params\" : [\"\"]\n"
            + "}", MyError.class);