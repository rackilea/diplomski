Pattern p = Pattern.compile("([^_]+)_(.+)");
Matcher m = p.matcher(s);
if (m.find()) {
  String first = m.group(1);  // Armor
  String second = m.group(2); // Blessed_Robes
}