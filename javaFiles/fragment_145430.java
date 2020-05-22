String decoded = new String(encryptedByteArray, "ISO-8859-1");
    System.out.println("decoded:" + decoded);

    byte[] encoded = decoded.getBytes("ISO-8859-1"); 
    System.out.println("encoded:" + java.util.Arrays.toString(encoded));

    String decryptedText = encrypter.decrypt(encoded);