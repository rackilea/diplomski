String[] strings = { "Dauresselam", "slab", "fuss", "boolean", "clap" };

String regex = "([a-z])\\1";
Pattern pattern = Pattern.compile(regex);

for (String string : strings) {
    Matcher matcher = pattern.matcher(string);
    if (matcher.find()) {
        System.out.println(string);
    }
}