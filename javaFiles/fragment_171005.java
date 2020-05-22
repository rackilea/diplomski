if (Cipher.getMaxAllowedKeyLength("AES") < 256) {
  try {
    Field field = Class.forName("javax.crypto.JceSecurity").
    getDeclaredField("isRestricted");
    field.setAccessible(true);
    field.set(null, java.lang.Boolean.FALSE);
  } catch (Exception e) {
    fail("Could not override JCE cryptography strength policy setting");
    fail(e.getMessage());
  }
}