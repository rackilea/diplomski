public static void main(String[] args) throws Exception {
    foo(1);
    foo2(1);
    }

    private static void foo2(final int number) throws Exception {
    Exception ex;
    if (number < 0) {
        ex = new Exception("No negative number please!");
        // throw ex; //nothing happens until you throw it
    }

    }

    private static void foo(final int number) throws Exception {
    if (number < 0) {
        throw new Exception("No negative number please!");
    }

    }