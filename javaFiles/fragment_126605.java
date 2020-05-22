final Gson gson = new Gson();
final List<String> ids = gson.fromJson(JSON, OuterWithMap.class)
        .divisions
        .values() // use map values only ignoring the keys
        .stream()
        .map(d -> d.id)
        .collect(toList());
System.out.println(ids);