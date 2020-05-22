public void test(int a)
{
    if(a<5)
    {
        System.out.print(a+" ");
        test(++a);
        System.out.println(a);
    }
    System.out.println("fin");
}