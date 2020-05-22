String str = "$!#";

StringBuilder digits = new StringBuilder();
for (int i=0; i<str.length(); i++) {
  int c = int(str.charAt(i));
  digits.append(c);
}