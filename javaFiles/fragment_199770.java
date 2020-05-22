Map<String, List<String>> map = new HashMap<>();
List<String> list = Arrays.asList("One", "Two", "Three");

for (Map.Entry<String, List<String>> mapValue : map.entrySet()) {
    for (String listValue : mapValue.getValue()) {
        // Do stuff

    }
}