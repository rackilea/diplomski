public class C <T> {
        private String a;
        private String b;
        private String c;
        private T d;
    }

    public class A {
        private SomeObject z;
    }

    public class B {
        private OtherObject z;
        private Integer y;
    }

    // example of usage
    C<A> a = new C<>();
    a.setD(new A());
    // and so on
    C<B> b = new C<>();
    b.setD(new B());
    // and so on