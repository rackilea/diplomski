class StreamToInflateStringToMap {
    private static Function<String, String> keyMapper =
            s -> s.substring(0, s.indexOf(":"));
    private static Function<String, String> valueMapper =
            s -> s.substring(s.indexOf(":") + 1);

    public static Map<String, String> inflateStringToMap(String flatString) {
        return Stream.of(flatString.split(";")).
                collect(Collectors.toMap(keyMapper, valueMapper));
    }

    public static void main(String[] args) {
        String flatString = "type:fruit;color:yellow;age:5";
        System.out.println("Flat String:\n" + flatString);
        Map<String, String> inflatedMap = inflateStringToMap(flatString);
        System.out.println("Inflated Map:\n" + inflatedMap);
    }
}