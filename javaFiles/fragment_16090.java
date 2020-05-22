// create map to store
    Map<String, List<String>> map = new HashMap<String, List<String>>();


    // create list one and store values
    List<String> chairs = new ArrayList<String>();
    chairs.add("Wood");
    chairs.add("Metal");

    // create list two and store values
    List<String> tables = new ArrayList<String>();
    tables.add("4-seater");
    tables.add("6-seater");

    // put values into map
    map.put("Chairs", chairs);
    map.put("Tables", tables);

    // iterate and display values
    System.out.println("Fetching Keys and corresponding [Multiple] Values");
    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
        String key = entry.getKey();
        List<String> values = entry.getValue();
        System.out.println("Key = " + key);
        System.out.println("Values = " + values);
    }