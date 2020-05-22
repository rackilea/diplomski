List<String> names = Arrays.asList("jon", "snow", "stark", "arya");
String text = "jon snow and Stark arya and again Jon Snow";

StringBuilder regexBuilder = new StringBuilder();

for (int i = 0; i < names.size(); i += 2) {
    regexBuilder.append("(")
        .append(names.get(i))
        .append(" ")
        .append(names.get(i + 1))
        .append(")");
    if (i != names.size() - 2) regexBuilder.append("|");
}

System.out.println(regexBuilder.toString());

Pattern compile = Pattern.compile(regexBuilder.toString(), Pattern.CASE_INSENSITIVE);

Matcher matcher = compile.matcher(text);

List<String> found = new ArrayList<>();

int start = 0;
while (matcher.find(start)) {
    String match = matcher.group().toLowerCase();

    if (!found.contains(match)) found.add(match);
    start = matcher.end();
}

for (String s : found) System.out.println("found: " + s);