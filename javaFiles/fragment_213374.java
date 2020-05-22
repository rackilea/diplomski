public class A {
    public void method() {
        int i = 0; // note: this is WRONG code

        doStuff(new Action() {
            public void doAction() {
                Console.printf(i);   // or whatever
            }
        });

        i = 4; // A
        // B
        i = 5; // C
    }
}