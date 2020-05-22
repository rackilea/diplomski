public class ExceptionThrownTest {

    @Test
    public void testingExceptions() {

        try {
            ExceptionThrownTest.main(new String[] {});
        } catch (Throwable e) {
            assertTrue(e instanceof RuntimeException);
        }

    }

    public static void main(String[] args) throws FileNotFoundException {

        dangerousMethod();

        // Won't be executed because RuntimeException thrown
        unreachableMethod();

    }

    private static void dangerousMethod() {
        throw new RuntimeException();
    }

    private static void unreachableMethod() {
        System.out.println("Won't execute");
    }
}