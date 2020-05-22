ObjectMapper mapper = new ObjectMapper();
List<Data> data = mapper.readValue(jsonString, List.class);

List<String> key1s = data.stream().map(d -> d.getKey1()).collect(Collectors.toList());

List<String> key2s = data.stream().map(d -> d.getKey2()).collect(Collectors.toList());