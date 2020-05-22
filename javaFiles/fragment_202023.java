class A
{
    static void foo(){ }
}
class B extends A
{
    static void foo(){ }
}
void test()
{
    A.foo();
    B.foo();
}