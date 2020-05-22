StringBuilder sb = new StringBuilder();
String sep = "";
for (String s : mimeList) {
    sb.append(sep + key + "=" + s);
    sep = " or ";
}