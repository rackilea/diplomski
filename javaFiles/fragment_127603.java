String seed = "ipNumber";
String myIpValue = "192.168.0.1";

StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
encryptor.setPassword(seed);
String encrypted= encryptor.encrypt(myIpValue);