PemReader reader = new PemReader(new FileReader("spki.pem"));
PemObject readPemObject = reader.readPemObject();
String type = readPemObject.getType();
byte[] subjectPublicKey = readPemObject.getContent();

System.out.println(type);

X509EncodedKeySpec spec = new X509EncodedKeySpec(subjectPublicKey);
KeyFactory kf = KeyFactory.getInstance("RSA");
RSAPublicKey pubKey = (RSAPublicKey) kf.generatePublic(spec);
System.out.println(pubKey);