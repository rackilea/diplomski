public static String matchCamelCase(String query, String str) {
    query = query.replaceAll("\\*", ".*?");
    String re = "\\b(" + query.replaceAll("([A-Z][^A-Z]*)", "$1[^A-Z]*") + ".*?)\\b";

    System.out.println(re);
    Pattern regex = Pattern.compile(re);

    Matcher m = regex.matcher(str);

    if  (m.find()) {
        return m.group();
    } else return null;
}