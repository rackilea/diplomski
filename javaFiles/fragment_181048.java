class Child
{
    Parent objParent = new Parent()
    {
        void displayMsg()
        {
            System.out.println("Display Msg for Parent");
        }

        void someMethod() {

        }
    };

    void CallMe()
    {
        objParent.displayMsg();
    }
}