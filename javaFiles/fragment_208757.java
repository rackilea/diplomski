String prefix = "TEST_";
String suffix = "";
String itemString = prefix + "item_1" + suffix;
String prefix_quote = "".equals(prefix) ? "^" : Pattern.quote(prefix);
String suffix_quote = "".equals(suffix) ? "$" : Pattern.quote(suffix);
String regex = "(?<=^|" + prefix_quote + ")(.*?)(?=$|" + suffix_quote + ")";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(itemString);