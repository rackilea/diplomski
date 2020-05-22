String s1, s2; /* input strings */

StringBuilder sb = new StringBuilder();
for (int i = 0; i < s1.length(); i++) {
  sb.append(s1.charAt(i));
  sb.append(s2.charAt(i));
}

String result = sb.toString();