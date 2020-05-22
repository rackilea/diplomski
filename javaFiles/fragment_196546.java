try {
byte[] utf8Bytes = original.getBytes("UTF8");
byte[] defaultBytes = original.getBytes();

String roundTrip = new String(utf8Bytes, "ISO-885-9");
System.out.println("roundTrip = " + roundTrip);
System.out.println();
printBytes(utf8Bytes, "utf8Bytes");
System.out.println();
printBytes(defaultBytes, "defaultBytes");
} catch (UnsupportedEncodingException e) {
 e.printStackTrace();
}