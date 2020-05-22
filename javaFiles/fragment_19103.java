class Main
{
    public static void main(String[] args)
    {
        A a = new A();
        B b = new B();
        C.SomeStatic(a); // will call A's a
        C.SomeStatic(b); // will call B's a
        // AND THIS IS POLYMORPHISM
        // C will decide WHICH METHOD TO CALL 
        // only at runtime
    }
}