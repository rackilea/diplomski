public class Example {

    private static class InnerMost implements AutoCloseable {
        public InnerMost() throws Exception {
            System.out.println("Constructing " + this.getClass().getName());
        }

        @Override
        public void close() throws Exception {
            System.out.println(this.getClass().getName() + " closed");
        }
    }

    private static class Middle implements AutoCloseable {
        private AutoCloseable c;

        public Middle(AutoCloseable c) {
            System.out.println("Constructing " + this.getClass().getName());
            this.c = c;
        }

        @Override
        public void close() throws Exception {
            System.out.println(this.getClass().getName() + " closed");
            c.close();
        }
    }

    private static class OuterMost implements AutoCloseable {
        private AutoCloseable c;

        public OuterMost(AutoCloseable c) throws Exception {
            System.out.println("Constructing " + this.getClass().getName());
            throw new Exception(this.getClass().getName() + " failed");
        }

        @Override
        public void close() throws Exception {
            System.out.println(this.getClass().getName() + " closed");
            c.close();
        }
    }

    public static final void main(String[] args) {
        // DON'T DO THIS
        try (OuterMost om = new OuterMost(
                new Middle(
                    new InnerMost()
                    )
                )
            ) {
            System.out.println("In try block");
        }
        catch (Exception e) {
            System.out.println("In catch block");
        }
        finally {
            System.out.println("In finally block");
        }
        System.out.println("At end of main");
    }
}