Webb webb = Webb.create();
    JSONObject result = webb
        .post("https://www.example.com/tickets/search")
        .param("param1", "value1")
        .param("param2", "value2")
        .asJsonObject()
        .getBody();