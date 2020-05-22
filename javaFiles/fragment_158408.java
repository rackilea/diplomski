Gson gson = new Gson();

    Map<String, Collection<String>> map = new HashMap<>();
    map.put("vendor", vendor);
    map.put("product", product);
    //etc

    System.out.println(gson.toJson(map));