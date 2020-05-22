String str="{" +
            "    \"f1\" : \"volume\"," +
            "    \"f2\" : \"gender\"," +
            "    \"f3\" : \"days\"," +
            "    \"f4\" : [{" +
            "            \"id\" : \"F\"," +
            "            \"name\" : \"female\"," +
            "            \"values\" : [{" +
            "                    \"name\" : \"September\"," +
            "                    \"value\" : 12" +
            "                }" +
            "            ]" +
            "        }, {" +
            "            \"id\" : \"M\"," +
            "            \"name\" : \"male\"," +
            "            \"values\" : [{" +
            "                    \"name\" : \"September\"," +
            "                    \"value\" : 11" +
            "                }" +
            "            ]" +
            "        }" +
            "    ]" +
            "}";
    JsonParser parser=new JsonParser();
    JsonObject object=(JsonObject)parser.parse(str);
    String value=object.get("f4").getAsJsonArray().get(0).getAsJsonObject()
            .get("values").getAsJsonArray().get(0).getAsJsonObject()
            .get("value").getAsString();