public class Test {
    public static void main(String[] args) throws Exception {
        Inner i = new Inner(); // Create an instance of Inner
        Inner.Private p = i.new Private(); // Create an instance of Private through
                                           // the instance of Inner, this is needed since
                                           // Private is not a static class.

        System.out.println(p.powerof2(2)); // Call the method
    }

    static class Inner {
        private class Private {
            private String powerof2(int num) {
                return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
            }
        }
    }
}