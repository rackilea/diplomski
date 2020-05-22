//Build a blank keystore with a password
KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
char[] password = "some password".toCharArray();
ks.load(null, password);

//Sample key storage
javax.crypto.SecretKey mySecretKey;
KeyStore.SecretKeyEntry skEntry =
    new KeyStore.SecretKeyEntry(mySecretKey);
ks.setEntry("secretKeyAlias", skEntry, 
    new KeyStore.PasswordProtection(password));

//Update the keystore file
fos = new java.io.FileOutputStream("keystorefilename");
ks.store(fos, password);