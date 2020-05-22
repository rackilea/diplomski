public class Second
{
    public void doSomething(SomeInterface si)
    {
        si.doThis();
        // other code here...
    }
}

// Some code outside those classes, that uses both classes...

Second s = new Second();
SomeInterface si = new Main();
s.doSomething(si);