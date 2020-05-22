String jsonString = " {\n" +
            "                        \"query\": {\n" +
            "                        \"bool\": {\n" +
            "                            \"must\": [\n" +
            "                                    {\"match\": \n" +
            "            { \"customer.partnerName\":   \"Synapse\"  }},\n" +
            "\n" +
            "                                    {\n" +
            "\"range\" : \n" +
            "{\n" +
            "                                        \"customer.billing.chargeAmount\" : {\n" +
            "                                            \"gte\" : 1,\n" +
            "                                            \"lte\" : 100\n" +
            "                                        }\n" +
            "                                    }}\n" +
            "                            ],\n" +
            "                            \"filter\": [\n" +
            "                                    { \"match\":  { \"customer.configId\": 15 }}\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    }\n" +
            "                    }";

    // HERE BEAUTIFIED
    /*jsonString = "{\"query\":{\"bool\":{\"must\":[{\"match\":{\"customer.partnerName\":\"Synapse\"}},{\"range\":{\"customer.billing.chargeAmount\":{\"gte\":1,\"lte\":100}}}],\"filter\":[{\"match\":{\"customer.configId\":15}}]}}}";
     */

    try {
        JSONObject object = new JSONObject(jsonString);

        // NO ERRORS, OBJECT CREATED IN MY CASE
    } catch (JSONException e) {
        e.printStackTrace();
    }