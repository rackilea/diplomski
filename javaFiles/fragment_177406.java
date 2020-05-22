// Get the data to be wrote to file.
String data = ...

// cipher the data.
char[] chars = data.toCharArray();
for (int i = 0; i < chars.length; ++i) {
    chars[i] = (char)(chars[i] + shift);
}
String cipher = new String(chars);

// Write the data to the cipher file.
...