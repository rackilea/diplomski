public class WhyImmutableClassesShouldBeFinal {
    /*
     * This is an immutable class
     */
    private static class ImmutableClass {
        private final String data;

        public ImmutableClass(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }
    }

    /*
     * This extends an immutable class, but is not immutable.
     */
    private static class NotSoImmutableClass extends ImmutableClass {
        private int oops;

        public NotSoImmutableClass() {
            super("WHATEVER");
        }

        public String getData() {
            return Integer.toString(oops++);
        }
    }

    /*
     * Here's some function that looks like it returns an immutable class but
     * doesn't.
     */
    private static ImmutableClass immutableClassProducer() {
        return new NotSoImmutableClass();
    }

    public static void main(String[] args) {
        /*
         * I called a method and got an ImmutableClass back.
         */
        ImmutableClass c = immutableClassProducer();

        /*
         * But why is the value changing?
         */
        System.out.println(c.getData());
        System.out.println(c.getData());
        System.out.println(c.getData());
        System.out.println(c.getData());
    }
}