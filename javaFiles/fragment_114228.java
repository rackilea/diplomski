SecretKeyFactory factory = SecretKeyFactory.getInstance(pbkdf2Algorithm);
KeySpec spec = new PBEKeySpec(passphrase.toCharArray(), salt.getBytes(charset), iterationCount, keyStrength);
SecretKey secret = factory.generateSecret(spec);
SecretKeySpec key;
//noinspection SynchronizationOnLocalVariableOrMethodParameter
synchronized(secret) {
  key = new SecretKeySpec(secret.getEncoded(), keyAlgorithm);
}