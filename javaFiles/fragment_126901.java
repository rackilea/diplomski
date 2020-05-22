String line = "My name $is John $Smith";
Pattern pattern = Pattern.compile("(\\$\\S+)");
Matcher matcher = pattern.matcher(line);

while (matcher.find()) {
    System.out.println(matcher.group(1));
}