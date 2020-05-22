String decompressed = "[-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72]";
String[] input = decompressed.replaceAll("[\\[\\]]", "").split(", ");
byte[] output = new byte[input.length];
for (int i = 0; i < input.length; i++) {
    output[i] = Byte.parseByte(input[i]);
}
System.out.println(new String(output));