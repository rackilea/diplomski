public static void main(String[] args) {
    String input = "{  \n" +
            "   \"videoUrl\":\"\",\n" +
            "   \"available\":\"true\",\n" +
            "   \"movie\":{  \n" +
            "      \"videoUrl\":\"http...\"\n" +
            "   },\n" +
            "   \"account\":{  \n" +
            "      \"videoUrl\":\"http...\",\n" +
            "      \"login\":\"\",\n" +
            "      \"password\":\"\"\n" +
            "   }\n" +
            "} ";

    Pattern pattern = Pattern.compile("(\"videoUrl\":)(\"http.+\")(?!,)");
    Matcher matcher = pattern.matcher(input);
    while (matcher.find()) {
        System.out.println(matcher.group());  // "videoUrl":"http..."
    }
}