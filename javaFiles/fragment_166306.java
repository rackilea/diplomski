public FooService getEJB() {
    try {
        Context ctx = new InitialContext();
        Object obj = ctx.lookup("java:/production/FooServ");
        return (FooService) obj;
    } catch (NamingException e) {
        e.printStackTrace();
    }
}