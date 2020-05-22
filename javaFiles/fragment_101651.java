file = file.replaceAll("\\\\\\n\\n", "");
Pattern pattern = Pattern.compile("^ *([a-zA-Z0-9_]+) *= *(.+?) *$");
Matcher matcher = pattern.matcher(file);
while (matcher.find()) {
  System.out.println(matcher.group(1)); // left side of = (already trimmed)
  System.out.println(matcher.group(2)); // right side of = (already trimmed)
}