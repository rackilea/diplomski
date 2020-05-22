public static String expandUserIDStr(String json) {
    String key = "user_id";
    String expandKey = "user_id_str";

    String r = "\"" + key + "\":(\\d+)[,]{0,1}";
    Pattern patter = Pattern.compile(r);
    Matcher matcher = patter.matcher(json);

    StringBuffer buffer = new StringBuffer();
    while (matcher.find()) {
        String expandContent = "\"" + expandKey + "\":\"" + matcher.group(1) +"\"," + matcher.group(0);
        System.out.println(expandContent);
        matcher.appendReplacement(buffer, expandContent);
    }
    matcher.appendTail(buffer);

    return buffer.toString(); 
}