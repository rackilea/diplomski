String[] test = {"p0", "blap10foo", "p*&^", "d10"};
Pattern p = Pattern.compile("p\\d+");
for (String s: test) {
    Matcher m = p.matcher(s);
    if (m.find()) {
        System.out.printf("Found: %s%n", m.group());
    }
}