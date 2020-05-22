StringBuilder sb = new StringBuilder();
sb.append(Integer.toHexString(myInt));
if (sb.length() % 2 > 0) {
    sb.insert(0, '0'); // pad with leading zero if needed
}
String hex = sb.toString();