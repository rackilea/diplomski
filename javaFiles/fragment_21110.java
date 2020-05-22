String transformation = "DESede/CBC/NoPadding";
String secretKeySpecAlgorithm = "DESede";
GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
// set up the poolConfig here
poolConfig.setMaxTotal(20);
CipherFactory cipherFactory = new CipherFactoryImpl(poolConfig, transformation, Cipher.DECRYPT_MODE, mkkey, algParamSpec, secretKeySpecAlgorithm);