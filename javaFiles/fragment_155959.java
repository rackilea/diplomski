String input = ... // my UTF-16 string
byte[] ascii = new byte[input.length()];
for (int i = 0; i < input.length(); i++) {
    char ch = input.charAt(i);
    ascii[i] = (ch <= 0xFF) ? (byte) ch : (byte) '?';
}