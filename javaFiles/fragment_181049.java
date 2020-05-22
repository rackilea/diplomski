class Child
{
    Parent objParent = new Parent()
    {
        void someMethod() {

        }
    };

    void CallMe()
    {
        objParent.displayMsg();
    }
}