StringBuilder sb = new StringBuilder();
sb.append(string1);
if (!string2.isEmpty()) {
    sb.append("~").append(string2);
}
if (!string3.isEmpty()) {
    sb.append("~").append(string3);
}
if (!string4.isEmpty()) {
    sb.append("~").append(string4);
}
String phone = sb.toString();