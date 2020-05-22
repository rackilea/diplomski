// non abstract
class A
{
    public void a()
    {
        System.out.println("Hello from A");
    }
}

class B
   extends A
{
    @Override
    public void a()
    {
        System.out.println("Hello from B");
    }
}

class C
{
    public static void SomeStatic(A a)
    {
         // HERE IS WHERE POLYMORPHISM OCCUR
         a.a();
    }
}