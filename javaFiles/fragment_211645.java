public class WithMethodRefs {
    interface MyReference {
        boolean method(int a);
    }

    boolean method1(int a) {
        return true;
    }

    boolean method2(int a) {
        return false;
    }

    public void doIt(int someInt) {
        MyReference p = null;
        switch (someInt) {
        case 1:
            p = this::method1;
            break;
        case 2:
            p = this::method2;
            break;
        }

        for (int i = 0; i < 100; i++) {
            p.method(i);
        }
    }
}