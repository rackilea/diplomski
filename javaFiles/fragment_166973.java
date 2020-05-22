KeyStore keystore = KeyStore.getInstance("PKCS12");
keystore.load(new FileInputStream(certificateFile), certificatePassword.toCharArray());
Key key = keystore.getKey(certName, certificatePassword.toCharArray());
Certificate cert = keystore.getCertificate(certName);
PublicKey publicKey = cert.getPublicKey();
KeyPair keys = new KeyPair(publicKey, (PrivateKey) key);