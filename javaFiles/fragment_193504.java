public static void main(String[] args) throws Exception {
    final String[] companies = {"Company1", "Company2", "Company3"};
    final String[] names = {"Alice", "Bob", "Eve"};
    final String originaltext = "This is {company, 0}, This is {name, 1}, This is {name, 2}";
    final Map<String, String[]> values = new HashMap<>();
    values.put("company", companies);
    values.put("name", names);
    final Pattern pattern = Pattern.compile("\\{([^,]++),\\s*+(\\d++)}");
    final Matcher matcher = pattern.matcher(originaltext);
    final StringBuffer sb = new StringBuffer();
    while (matcher.find()) {
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
        final int index = Integer.parseInt(matcher.group(2));
        matcher.appendReplacement(sb, values.get(matcher.group(1))[index]);
    }
    matcher.appendTail(sb);
    System.out.println(sb);
}