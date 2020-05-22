class A
{
    void f(Object o)
    {
        System.out.println("From A");
    }
}
class B extends A
{

    void f(Object o)
    {
        System.out.println("From B (Object)");
    }

    void f(String s)
    {
        System.out.println("From B (String)");
    }
}