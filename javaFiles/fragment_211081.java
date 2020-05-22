class OverrideSuper {
    public void printHello() {
        System.out.println("Print Hello");
    }
}
    public class Overriding extends OverrideSuper {
            public void printHello() {
                super.printHello();
                System.out.println("NO NO PRINT HI");
            }

            public static void main(String[] args) {
                // OverrideSuper obj1 = new OverrideSuper();
                Overriding obj2 = new Overriding();
                obj2.printHello();// this calls printHello() of class Overriding.
                // I want to call printHello() of OverrideSuper using obj2. How do I do
                // that???
            }
        }