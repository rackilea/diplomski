StringBuilder sb = new StringBuilder();
for (int i=0; i < count; i++) {
    sb.append(words[i]).append(",");
}
String output = sb.toString().replaceAll(",$", "");
System.out.println(output);