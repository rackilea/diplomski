public static void main(String[] args) throws Exception {
    Map<String, String> replacerMap = new HashMap() {{
        put("xxx", "CCC");
        put("yyy", "DDD");
    }};

    String raw = "John Doe xxx Amazing man BEGIN reference xxx yes yyy indeed this is true xxx no yyy END , so this xxx does not change";
    System.out.println("Before: ");
    System.out.println(raw);
    System.out.println();

    for (Map.Entry<String, String> kvp : replacerMap.entrySet()) {
        Matcher matcher = Pattern.compile(String.format("BEGIN.*?(%s).*?END", kvp.getKey())).matcher(raw);
        if (matcher.find()) {
            raw = raw.replace(matcher.group(), matcher.group().replace(matcher.group(1), kvp.getValue()));
        }
    }

    System.out.println("After: ");
    System.out.println(raw);
}