Object lookedUp = null;
try {
    InitialContext initialContext = new InitialContext();
    lookedUp = initialContext.lookup("java:/comp/env/testEnvEntry");
} catch (NamingException e) {
    e.printStackTrace();
}