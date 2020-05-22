private static Map<String, String> parse(String digest) {
    String[] parts = digest.split(", ");
    Map<String, String> map = new HashMap<String, String>();
    for (String x : parts) {
        String[] bits = x.split("=");

        //Remove "'s here if you want to keep them in the string

        map.put(bits[0], bits[1]);
    }
    return map;
}