List<String> strs = Arrays.asList("up to 1 gb output", "up to 1gb output", "up   to1 gb output", "1 gb output");
Pattern p = Pattern.compile("(?i)\\b(?<!\\bup\\s{0,100}to\\s{0,100})\\d+\\s*[GMK]B\\b");
for (String str : strs) {
    Matcher m = p.matcher(str);
    while (m.find()) {
        System.out.println(str + ": " + m.group(0));
    }
}