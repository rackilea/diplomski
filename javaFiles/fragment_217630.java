Map<String, String> map = new HashMap<>();
    map.put("key1", "value1");
    map.put("key2", "value2");

    //convert it to json maually
    StringBuilder builder = new StringBuilder();
    builder.append("\"foo\":{");
        builder.append("\n");
    for (String key : map.keySet()) {
        builder.append("\t");
        builder.append("\"").append(key).append("\"");
        builder.append(":");
        builder.append("\"").append(map.get(key)).append("\"");
        builder.append(",");
        builder.append("\n");
    }
    builder.append("\t}");

    String json = builder.toString();
    System.out.println(json);