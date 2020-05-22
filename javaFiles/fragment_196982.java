private static Set<String[]> getSuccessCodes(HashMap<String, String> codes){
    Set<String[]> successCodes = new HashSet<>();
    String value;
    for (Map.Entry<String, String> entry : codes.entrySet()) {
        value = entry.getValue();
        if(!StringUtils.isEmpty(value))
            successCodes.add(parse(value));
    }
    return successCodes;
}
public static String[] parse(String val) {
    String[] parts = val.split("\\s*,\\s*(?![^\\[]*\\])");
    return Arrays.stream(parts)
          .map(e -> e.contains("[")? getRangeCodes(e): e.contains("*")? getWildCCodes(e): e)
          .collect(Collectors.joining(",")).split("\\s*,\\s*");
}
private static String getRangeCodes(String e) {
    e = e.substring(1, e.length()-1);
    return IntStream.rangeClosed(Integer.parseInt(e.split("\\s*,\\s*")[0]), Integer.parseInt(e.split("\\s*,\\s*")[1]))
            .mapToObj(i -> String.valueOf(i))
            .collect(Collectors.joining(","));
}

private static String getWildCCodes(String e) {
    return IntStream.rangeClosed(Integer.parseInt(e.replace('*', '0')), Integer.parseInt(e.replace('*', '9')))
            .mapToObj(i -> String.valueOf(i))
            .collect(Collectors.joining(","));
}