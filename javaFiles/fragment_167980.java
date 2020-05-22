public class A{
    void m1()
    {
        .....

        B b=new B();
        b.m1() ; //will call only method m1 in B
        b.m2() ; //will call only method m2 in B

        b.callAll() ;  //will call both m1 and m2 method in B

        ....
    }
}



public class B
{

    void m1()
    {
        ....
    }


    void m2()
    {
        ....
    }


    void callAll()
    {
        m1();
        m2();
    }

}