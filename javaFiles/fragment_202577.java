public class C
{
    public static void main(String [] args)
    {
        A a = new A();
        B b = new B();
        C c = new C();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }


    public String toString() { return C.class.getName(); }
}