// ByteBuffer to base64
 byte[] data = new byte[encryptedText.remaining()]
 encryptedText.get(data);
 String dataB64 = DataTypeConverter.printBase64Binary(data);

 //Add claim
 claimsSet.setClaim("myObject", dataB64);