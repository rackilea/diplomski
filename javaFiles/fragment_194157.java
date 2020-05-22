public class Test1 {

    public static void main(String[] args) {
        SubTest1 test = new SubTest1() {
            public void m() {
                System.out.println("m");
            }
        };
    }

    private static abstract class SubTest1 extends Test1 {
        public SubTest1() {
            this.m();
        }

        public abstract void m();
    }
}