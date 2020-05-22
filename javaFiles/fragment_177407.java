// Read the cipher file.
String data = ...

// Decipher the data.
char[] chars = data.toCharArray();
for (int i = 0; i < chars.length; ++i) {
    chars[i] = (char)(chars[i] - shift);
}
String decipher = new String(chars);

// Use data as required.
...