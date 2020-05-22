public class ClassB
{
    private Dispatcher dispatcher;

    public ClassB()
    {
        dispatcher = new NullDispatcher();
    }

    public void setDispatcher(Dispatcher dispatcher)
    {
        // change this to your needs
        if (dispatcher == null)
            dispatcher = new NullDispatcher();
        else
            this.dispatcher = dispatcher;
    }

    @Test
    public void myTest()
    {
        ClassA a = new ClassA();
        a.createRequest();
        String test = a.getResponse();

        dispatcher.dispatch(test);
    }
}