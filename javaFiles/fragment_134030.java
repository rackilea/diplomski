Provider p = new SunPKCS11(new ByteArrayInputStream(config.getBytes()));
Security.insertProviderAt(p, 1);
KeyStore.Builder builder = null;
builder = KeyStore.Builder.newInstance("PKCS11", p, 
    new KeyStore.CallbackHandlerProtection(new UtilTarjetas().new CustomCallbackHandler()));
cardKeyStore = builder.getKeyStore();