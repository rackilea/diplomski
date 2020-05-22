int length = 0;
for (int i = 0; i < strings.length; ++i) {
    length += strings[i].length();
}
length += strings.length - 1; // For the commas
StringBuilder sb = new StringBuilder(length);
sb.append(strings[0]);
for (int i = 1; i < strings.length; ++i) {
    sb.append(',');
    sb.append(strings[i]);
}
String result = sb.toString();