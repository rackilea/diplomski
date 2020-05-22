public static boolean isTrusted() {
  boolean trusted = false;
  try {
    SecurityManager sm = System.getSecurityManager();
    // not permitted in a sand-boxed app.
    System.setSecurityManager(null);
    // restore the trusted security manager.
    System.setSecurityManager(sm);
    // This code must be trusted, to reach here.
    trusted = true;
  catch(Throwable ignore) {}
  return trusted;
}