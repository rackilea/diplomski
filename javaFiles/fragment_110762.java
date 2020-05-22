private Map<String, String> toMap(Div div) {
    Map<String, String> result = new HashMap<>();
    result.put("id", div.getId().toString());
    result.put("name", div.getName());
    return result;
}