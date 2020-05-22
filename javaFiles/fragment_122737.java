PublicKey pub = keyPair.getPublic();
    byte[] pubBytes = pub.getEncoded();
    PemObject pemObject = new PemObject("PUBLIC KEY", pubBytes);
    StringWriter stringWriter = new StringWriter();
    PemWriter pemWriter = new PemWriter(stringWriter);
    pemWriter.writeObject(pemObject);
    pemWriter.close();
    System.out.println(stringWriter.toString());