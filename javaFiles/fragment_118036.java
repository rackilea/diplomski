String str = "TEST [52.5, 77.5]";
Pattern p = Pattern.compile("(.*?)\\s*\\[(.*)\\]");
Matcher m = p.matcher(str);

if (m.find()) {
    String first = m.group(1);
    String[] others = m.group(2).split("\\s*,\\s*");

    for (String other : others)
        System.out.println(first + " " + other);
}