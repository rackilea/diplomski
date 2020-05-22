String input = "...Your input...";
List<String> matches = new ArrayList<>();

Matcher m = Pattern.compile("(\\w+)\\s*(?=[,=])").matcher(input);
while(m.find()) {
    matches.add(m.group(1));
}