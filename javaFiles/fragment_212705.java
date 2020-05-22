List<String> recordSource =
        Arrays.asList(
            "{\"name\":\"Bob\",\"age\":40,\"favorite_pizza\":\"Cheese\"}",
            "{\"name\":\"Jill\",\"age\":22,\"favorite_candy\":\"Swedish Fish\"}");
    List<JSONObject> records =
        recordSource.stream().map(JSONObject::new).collect(Collectors.toList());

    JSONObject body = new JSONObject();

    // Add the "records" key
    body.put("records", records);
    System.out.println(body.toString());