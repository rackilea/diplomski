String s = "Lorem ipsum mauris \"libero\" non \"pulvinar\" suscipit, nis \"aenean\" curae odio lobortis \"nulla\" suspendisse";
Pattern p = Pattern.compile("(?!<\")\\b\\w+\\b(?!\")");
Matcher m = p.matcher(s);

while (m.find()) {
    System.out.println(m.group());
}