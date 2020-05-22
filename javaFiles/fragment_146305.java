Map<String, Integer> map = new HashMap<>();
for (String keyValue: json.split(",")) {
    String[] data = keyValue.split(":");
    map.put(
        data[0].replace("\"", """),
        Integer.valueOf(data[1].trim());
    );
}