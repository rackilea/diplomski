final JsonPath jsonPath = JsonPath.compile("$.divisions.*.id");
final List<String> ids = jsonPath.<JSONArray>read(JSON)
        .stream()
        .map(o -> (String) o)
        .collect(toList());
System.out.println(ids);