String input = ... // my UTF-16 string
StringBuilder sb = new StringBuilder(input.length());
for (int i = 0; i < input.length(); i++) {
    char ch = input.charAt(i);
    if (ch <= 0xFF) {
        sb.append(ch);
    }
}

byte[] ascii = sb.toString().getBytes("ISO-8859-1"); // aka LATIN-1