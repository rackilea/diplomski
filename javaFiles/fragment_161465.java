public static List<String> extract(String json, String key) {

    List<String> urls = new ArrayList<>();

    try {
        JSONObject jsonObject = new JSONObject(json);
        Map<String, Object> flattenedJsonMap =
                JsonFlattener.flattenAsMap(jsonObject.toString());
        flattenedJsonMap.forEach((k, v) -> {
                    if (k.contains(key)) {
                        urls.add(v.toString());
                    }
                }
        );
    } catch (Exception e) {
        e.printStackTrace();
    }

    return urls;

}