//For Get using Unirest
        HttpResponse<JsonNode> httpResponse = Unirest.get("https://jsonplaceholder.typicode.com/posts/1").asJson();
        String responseString = httpResponse.getBody().toString();
        JSONObject object = new JSONObject(responseString); //Converting to JSONObject since it supports more functionalities
        System.out.println(object.keySet());


        //For Post using Unirest
        httpResponse = Unirest.post("https://jsonplaceholder.typicode.com/posts").body("This is sample Body").asJson();
        object = new JSONObject(responseString);
        System.out.println(object.keySet());