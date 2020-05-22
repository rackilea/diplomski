ArrayList<String> names = new ArrayList<>();
String s = "->  ed sheeran . .  beyonce . .  katty perry . . .  ";
Pattern reg = Pattern.compile("\\w+\\s?\\w+");
Matcher m = reg.matcher(s);
while (m.find()) {
    names.add(m.group());
}
String[] someArray = names.toArray(new String[]{});