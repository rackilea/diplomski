static void extract(String string) {
    Pattern pattern =
            Pattern.compile("(?><col=(?<color>[A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})>)?(?<name>(?><.*?>)?[^<]+)");
    Matcher m = pattern.matcher(string);
    while (m.find()) {
        String color = m.group("color");
        String name = m.group("name");
        System.out.printf("Color %s, name %s\n", color, name);
    }
}
/*
Color null, name something before
Color ff00ff, name mercides> car
Color ffff00, name plates