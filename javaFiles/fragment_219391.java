Unirest.setTimeouts(1000000,1000000);
    HttpResponse<String> jsonResponse = Unirest.post(host)
            .header("Content-Type", "application/json")
            .body(String.format("{\"queryType\":\"%s\", \"query\":\"%s\"}", "SQL",
                    query))
            .asString();
    JSONParser parser = new JSONParser();
    String json = jsonResponse.getBody();
    return (JSONObject) parser.parse(json);