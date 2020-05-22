byte[] hex = x509Certificate.getEncoded();

  System.out.println("--------------------------------------");

  String hexText = DatatypeConverter.printHexBinary(hex);
  System.out.println(hexText);