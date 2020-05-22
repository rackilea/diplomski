Map<String, Object> m1 = new LinkedHashMap<>();
    m1.put("name", "Bob");
    m1.put("age", 40);
    m1.put("favorite_pizza", "Cheese");

    LinkedHashMap<String, Object> m2 = new LinkedHashMap<>();
    m2.put("name", "Jill");
    m2.put("age", 22);
    m2.put("favorite_candy", "Swedish Fish");
    List<LinkedHashMap<String, Object>> records = Arrays.asList(m1,m2);

    JSONObject body = new JSONObject();

    // Add the "records" key
    body.put("records", records);