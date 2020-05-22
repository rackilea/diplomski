public class Class1
{

    private NewClass1 newClass1;
    private NewClass2 newClass2;
    private JComponent jComponent;

    public Class1()
    {
        newClass1 = new NewClass1();
        newClass2 = new NewClass2();
        //instantiating jComponent
    }

    public void doSomething()
    {
        newClass1.doSomethingSmaller(jComponent); //possibly with some return value
        newClass2.doSomethingSmallerToo(jComponent); //possibly with some return value
    }
}

public class NewClass1
{
    public void doSomethingSmaller(JComponent jComponent)
    {
        //do stuff (1)
        jComponent.doStuff();
    }
}

public class NewClass2
{
    public void doSomethingSmallerToo(JComponent jComponent)
    {
        //do stuff (2)
        jComponent.doOtherStuff();
    ]
}