InputStream embeddedKeystore =
    MyApplication.class.getResourceAsStream("custom-keystore.pkcs");

assert embeddedKeystore != null : "Application was not properly built."
    + " Keystore is missing!";

KeyStore keystore = KeyStore.getInstance("pkcs12");
keystore.load(embeddedKeystore,
    new char[] { 's', 'w', 'o', 'r', 'd', 'f', 'i', 's', 'h' });

embeddedKeystore.close();