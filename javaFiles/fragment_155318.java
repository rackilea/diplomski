char[] ch = string.toCharArray();
for (int i = 0; i < ch.length; ++i) {
  if (Character.isDigit(ch[i])) {
    ch[i] = Character.forDigit(Character.getNumericValue(ch[i]), 10);
  }
}
String translated = new String(ch);