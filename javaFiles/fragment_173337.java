public class Main {
    public static I getClassBelongToCondition(boolean Condition) {
        if (Condition) {
            return new A();
        } else {
            return new C();
        }
    }

}

interface I {
}

class A extends B implements I {
}

class C extends D implements I {
}

class B {
}

class D {
}