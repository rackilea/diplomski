RestClient restClient = RestClient.builder(
                new HttpHost("localhost", 9200, "http")).build();

        Response response = restClient.performRequest("GET", "/twitter/_search",
               Collections.singletonMap("pretty", "true"));


/*
        JsonObject user = new JsonObject();
        user.addProperty("user","Yash");
        user.addProperty("post_date","2009-11-15T14:12:12");
        user.addProperty("message","Checking json");

        HttpEntity entity = new NStringEntity(user.toString());

        Response indexResponse = restClient.performRequest(
                "PUT",
                "/twitter/tweet/3",
                Collections.<String, String>emptyMap(),
                entity);
*/





        System.out.println(EntityUtils.toString(response.getEntity()));

        restClient.close();