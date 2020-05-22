public class ThisClass 
{
    private String decString = "some string";
    private SomeOtherClass someOtherClass;

    public ThisClass()
    {
        someOtherClass = new SomeOtherClass(this);
    }

    public String getDecString()
    {
        return decString;   
    }
}

public class SomeOtherClass 
{

    private ThisClass decHandle;
    private String valueForOther;

    public SomeOtherClass (ThisClass handle)
    {
        decHandle = handle;
        valueForOther = decHandle.getDecString(); 
    }  
}