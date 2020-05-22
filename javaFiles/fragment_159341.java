StringBuilder sb = new StringBuilder();
String sep = "";
for (String s : listObjs) {
    sb.append(sep).append(s);
    sep = ", ";
}
System.out.println(sb);