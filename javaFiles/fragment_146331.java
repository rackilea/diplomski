public String mapToMyString(Map<String, Integer> map) {
    StringBuilder builder = new StringBuilder("{");
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
        builder.append(entry.getKey()).append('=').append(entry.getValue()).append('\n');
    }
    builder.append('}');
    return builder.toString();
}

String stringRepresentation = mapToMyString(map);