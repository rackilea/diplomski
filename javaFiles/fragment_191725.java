String s = "Temperature: 98.6°F (37.0°C)";
StringBuilder buf = new StringBuilder();
for (int i = 0; i < s.length(); i++) {
    char c = s.charAt(i);
    if (c >= 0x20 && c <= 0x7E) // visible ASCII character
        buf.append(c);
    else
        buf.append(String.format("\\u%04x", (int) c));
}
String t = buf.toString();
System.out.println(t);