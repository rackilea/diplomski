void test() throws Exception {
    A a = null;
    B b = null;

    Exception myException = null;
    try {
        a = new A();
        b = new B();
        //useful work here
    } catch (Exception e) {
        myException = e;
        throw e;
    } finally {
        Throwable tA = handleCloaseable(a);
        Throwable tB = handleCloaseable(b);

        boolean throwIt = false;
        if (myException == null && tA != null || tB != null) {
            myException = new Exception();
            throwIt = true;
        }

        if (tA != null) {
            myException.addSuppressed(tA);
        }
        if (tB != null) {
            myException.addSuppressed(tB);
        }

        if (throwIt) {
            throw myException;
        }
    }
}

Throwable handleCloaseable(AutoCloseable e){ // your resources must implements AutoCloseable or Closeable
    if (e != null) {
        try {
            e.close();
        } catch (Throwable t) {
            return t;
        }
    }
    return null;
}