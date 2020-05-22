String json = ...;

JsonElement el = new Gson().fromJson(json, JsonElement.class);
// Get inner list
JsonArray list = el.getAsJsonObject()
    .get("list").getAsJsonArray()
    .get(0).getAsJsonObject()
    .get("list").getAsJsonArray();

// Make into a regular list, so we can stream
List<JsonObject> objects = new ArrayList<>();
list.forEach(e -> objects.add(e.getAsJsonObject()));

// Group by date, then by series description
Map<LocalDate, Map<String, List<JsonObject>>> result = objects.stream()
    .collect(
        Collectors.groupingBy(
            e -> LocalDateTime.ofInstant(
                Instant.ofEpochSecond(e.get("startDate").getAsLong()),
                    ZoneId.systemDefault()
            ).toLocalDate(),
            Collectors.groupingBy(e -> e.get("seriesDesc").getAsString())
        )
    );      

// Sorted printing
result.entrySet().stream()
    .sorted(Map.Entry.comparingByKey())
    .forEach(date -> {
        System.out.println(date.getKey());
        date.getValue().entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(group -> {
                System.out.println(group.getKey());
                group.getValue().forEach(System.out::println);
                System.out.println();
            });
    });