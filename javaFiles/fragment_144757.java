class M {
    class A1 { };
    class A2 { };

    interface B1 {
        void f(A1 a1);
    };
    interface B2 {
        void f(A2 a2);
    };

    abstract class D implements B1, B2 {
    }; 

    void f(D d)
    {
        A1 a1 = new A1();
        A2 a2 = new A2();
        d.f(a1);
        d.f(a2);
    }
};