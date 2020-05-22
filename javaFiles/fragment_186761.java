String toConvert = "abbbbbbbbbbbbbbbbbbbbbbc";
byte[] output = new byte[toConvert.length() / 2];

for (int i = 0; i < output.length; i++) {
    output[i] |= Character.digit(toConvert.charAt(i * 2), 16) * 16;
    output[i] |= Character.digit(toConvert.charAt(i * 2 + 1), 16);
}