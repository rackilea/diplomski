public class Main {
    public static class Test {
        public String text;
        public Test(String text) {
            this.text = text;
        }
        public void doit() {
            System.out.println(text);
        }
    }

    static void reference() {
        Test[] t = {new Test("This is class 0"), new Test("This is class 1")};

        attemptSwitch(t[0], t[1]);
        System.out.println();
        System.out.println("calling t[0].doit() outside attemptSwitch():");
        t[0].doit();
        System.out.println("calling t[1].doit() outside attemptSwitch():");
        t[1].doit();

        manipulate(t[0]);
        manipulate(t[1]);
        System.out.println();
        System.out.println("calling t[0].doit() after manipulate()");
        t[0].doit();
        System.out.println("calling t[1].doit() after manipulate()");
        t[1].doit();
    }

    static void attemptSwitch(Test t0, Test t1) {
        Test tmp = t0;
        t0 = t1;
        t1 = tmp;

        System.out.println("calling t0.doit() from inside attemptSwitch():");
        t0.doit();
        System.out.println("calling t1.doit() from inside attemptSwitch():");
        t1.doit();

    return;
    }

    public static void manipulate(Test t) {
        t.text = "This class has been manipulated!";
    }

}