static byte[] getPassword(KeyStore ks, String alias, char[] master)
  throws GeneralSecurityException, DestroyFailedException
{
  if (!ks.entryInstanceOf(alias, KeyStore.SecretKeyEntry.class))
    throw new IllegalArgumentException();
  KeyStore.PasswordProtection pp = new KeyStore.PasswordProtection(master);
  try {
    KeyStore.SecretKeyEntry e = (KeyStore.SecretKeyEntry) ks.getEntry(alias, pp);
    return e.getSecretKey().getEncoded();
  }
  finally {
    pp.destroy();
  }
}

static void setPassword(KeyStore ks, String alias, byte[] password, char[] master)
  throws GeneralSecurityException, DestroyFailedException
{
  SecretKey wrapper = new SecretKeySpec(password, "RAW");
  KeyStore.SecretKeyEntry entry = new KeyStore.SecretKeyEntry(wrapper);
  KeyStore.PasswordProtection pp = new KeyStore.PasswordProtection(master);
  try {
    ks.setEntry(alias, entry, pp);
  }
  finally {
    pp.destroy();
  }
}