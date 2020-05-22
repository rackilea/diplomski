public static void main(String... args) {

String text = "this is a.line is. over";

int pos = 0;
boolean capitalize = true;
StringBuilder sb = new StringBuilder(text);
while (pos < sb.length()) {
    if (sb.charAt(pos) == '.') {
        capitalize = true;
    } else if (capitalize && !Character.isWhitespace(sb.charAt(pos))) {
        sb.setCharAt(pos, Character.toUpperCase(sb.charAt(pos)));
        capitalize = false;
    }
    pos++;
}
System.out.println(sb.toString());
}