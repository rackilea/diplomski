String s = "[\n" +
            "    {\n" +
            "       \"date\":\"2013-11-19\",\n" +
            "       \"time\":\"10:30\"\n" +
            "    },\n" +
            "    {\n" +
            "       \"date\":\"2013-11-19\",\n" +
            "       \"time\":\"12:20\"\n" +
            "    }\n" +
            " ]";

    ObjectMapper mapper = new ObjectMapper();
    JsonNode array = mapper.readTree(s);
    JsonNode result = mapper.createObjectNode().set("result", array);
    System.out.println(result);