class SuperA
{
    public void test(SuperA a)
    {
        System.out.println("super class's test() is called");
    }
}

class SubB extends SuperA
{

    public void test(SubB subB)
    {
        System.out.println("subclass's test() is called");


    }    
}