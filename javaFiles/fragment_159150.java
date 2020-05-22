byte[]   bytesEncoded = Base64.encodeBase64(str .getBytes());
System.out.println("ecncoded value is " + new String(bytesEncoded ));

// Decode data on other side, by processing encoded data
byte[] valueDecoded= Base64.decodeBase64(bytesEncoded );
System.out.println("Decoded value is " + new String(valueDecoded));