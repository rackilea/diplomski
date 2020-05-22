Class Base
{
    public void foo() //a public interface to user
    {
        doA();
        doB();
    }
    protected void doA(){...} //common implementation
    protected void doB(){} //type specific implementation
}
Class Derived1 extends Base
{
    @Override
    protected void doB(){...} //implementation for Derived1
}
Class Derived2 extends Base
{
    @Override
    protected void doB(){...} //a different implementation for Derived2
}