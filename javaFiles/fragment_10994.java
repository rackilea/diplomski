public static void providerAndWrapperIssue() throws Exception
{
    final String name = "ANY_NAME";
    final String library = "LOCATION OF THE TOKENS DLL/SO";
    final String slot = "SLOT NUMBER";

    // SUN PKCS#11 Provider -------------------------------------------

    StringBuilder builder = new StringBuilder();
    builder.append("name=" + name);
    builder.append(System.getProperty("line.separator"));
    builder.append("library=\"" + library + "\"");
    builder.append(System.getProperty("line.separator"));
    builder.append("slot=" + slot);

    ByteArrayInputStream bais = new ByteArrayInputStream(builder.toString().getBytes());
    Provider provider = new sun.security.pkcs11.SunPKCS11(bais);
    provider.setProperty("pkcs11LibraryPath", library);
    Security.addProvider(provider);

    KeyStore ks = KeyStore.getInstance("PKCS11");
    ks.load(null, null);

    Enumeration<String> aliases = ks.aliases();
    while (aliases.hasMoreElements())
        System.out.println(aliases.nextElement());

    // ====================================
    // Solved it using the SUN PKCS#11 Wrapper

    PKCS11 pkcs11 = PKCS11.getInstance(((sun.security.pkcs11.SunPKCS11) provider).getProperty("pkcs11LibraryPath"), null, null, true);
    pkcs11.C_Finalize(PKCS11Constants.NULL_PTR);

    // ====================================

    // IAIK PKCS#11 Wrapper -------------------------------------------

    Module pkcs11Module = Module.getInstance(library, false);
    pkcs11Module.initialize(null);

    Slot[] slots = pkcs11Module.getSlotList(true);

    Session session = slots[0].getToken().openSession(true, true, null, null);
    session.login(Session.UserType.USER, "".toCharArray());

    session.logout();
    session.closeSession();

    slots[0].getToken().closeAllSessions();

    pkcs11Module.finalize(null);
}