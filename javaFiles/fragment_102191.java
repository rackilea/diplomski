transient KeyPairGenerator keyPairGenerator;

private KeyPairGenerator getGenerator() {
   if (keyPairGenerator == null) {
       keyPairGenerator = KeyPairGenerator.getInstance("RSA");
       keyPairGenerator.initialize(2048); //1024 used for normal securities
       ...
   }
   return keyPairGenerator;
}