enum EnumWithExceptions {
    ENUM1(Exception1.class, Exception2.class),
    ENUM2(Exception3.class);

    private final Class<? extends Exception>[] exceptions;

    private EnumWithExceptions(Class<? extends Exception>... exceptions) {
        this.exceptions = exceptions;
    }

    public boolean matches(Exception e) {
        for(Class<? extends Exception> e2: exceptions)
            if (e2.isInstance(e)) return true;
        return false;
    }
}