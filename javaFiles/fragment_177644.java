CallbackHandler callBackHandler = new yourImplementedHandler();
KeyStore.ProtectionParameter protection = new KeyStore.CallbackHandlerProtection(callBackHandler);
Provider provider = Security.getProvider("SunMSCAPI");
KeyStore.Builder keystoreBuilder = KeyStore.Builder.newInstance("Windows-MY",
                                                                provider, 
                                                                protection);
KeyStore keystore = keystoreBuilder.getKeyStore();