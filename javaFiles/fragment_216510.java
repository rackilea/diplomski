final String string = "12:00:00, 2:30:003:45:00,23:45:00";

final Pattern pattern = Pattern.compile("\\s*(\\d+:\\d\\d:\\d\\d)");
final Matcher matcher = pattern.matcher(string);
final List<String> tokens = new ArrayList<String>();
while (matcher.find()) {
    tokens.add(matcher.group(1));
}
System.out.println("tokens = " + tokens);

StringBuilder formattedString = new StringBuilder();
formattedString.append(tokens.get(0));
for (int i = 1; i < tokens.size(); i++) {
    if (i % 2 == 0) {
        formattedString.append(" | ");
    } else {
        formattedString.append(", ");
    }
    formattedString.append(tokens.get(i));
}
System.out.println(formattedString);