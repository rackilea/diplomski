public static List<String> extract(String json, String key) {

    List<String> urls = new ArrayList<>();

    String[] content = json.split(",");

    String keyStr = "\"" + key + "\":";

    for (String s : content) {
        if (s.trim().startsWith(keyStr))
            urls.add(s.trim().replace("\"", "").substring(7));
    }

    return urls;
}