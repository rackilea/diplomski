class Scratch {
    public static void main(String[] args) {
        A a = new A ("xyz");
    }
}

class A{
    public  B b = new B();
    private C c = new C(123);

    public A (String a){
        System.out.println("new A()");
    }
}

class B {
    public B() {
        System.out.println("new B()");
    }
}

class C {
    public C(int i) {
        System.out.println("new C()");
    }
}