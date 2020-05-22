byte[] aaa = new byte[1];
aaa[0] = (byte) 153;
System.out.println("original bytes <<>> " + Arrays.toString(aaa));

// Encode the bytes to Base64
String encoder = Base64.encodeBase64String(aaa);
System.out.println("encoder <<>> " + encoder);

// Decode the Base64 String to bytes
byte[] bytes = Base64.decodeBase64(encoder);
System.out.println("decoded bytes <<>> " + Arrays.toString(bytes));