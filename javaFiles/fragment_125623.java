public class ExceptionHandling {
    public String doSomething(final boolean throwException) {
        return logAndCleanup(new Callable<String>() {
            public String call() throws Exception {
                if (throwException) {
                    throw new Exception("you asked for it");
                }
                return "hello";
            }
        });
    }

    public Integer doSomethingElse() {
        return logAndCleanup(new Callable<Integer>() {
            public Integer call() throws Exception {
                return 42;
            }
        });
    }

    private <T> T logAndCleanup(Callable<T> callable) {
        try {
            return callable.call();
        }
        catch (Exception e) {
            System.out.println("An exception has been thrown: " + e);
            throw new RuntimeException(e); // or return null, or whatever you want
        }
        finally {
            System.out.println("doing some cleanup...");
        }
    }

    public static void main(String[] args) {
        ExceptionHandling eh = new ExceptionHandling();

        System.out.println(eh.doSomething(false));
        System.out.println(eh.doSomethingElse());
        System.out.println(eh.doSomething(true));
    }
}