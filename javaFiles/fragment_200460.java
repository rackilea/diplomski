public class MyClass
{
    private final String myVar;

    public MyClass(DataObj dataObj)
    {
        myVar = dataObj.getFinalVarValue(); // the only assignment/init happens here.
    }

    ....
}