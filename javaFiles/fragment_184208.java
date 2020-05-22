@Root(name = "child")
@Convert(value = ChildConverter.class) // Set the Converter
public class Child
{
    private boolean actived;
    @Element(name = "value", required = true)
    private String value;
    @Element(name = "value2", required = true)
    private int secondValue;


    public Child(boolean actived, String value, int secondValue)
    {
        this.actived = actived;
        this.value = value;
        this.secondValue = secondValue;
    }



    public boolean isActived()
    {
        return actived;
    }

    public String getValue()
    {
        return value;
    }

    public int getSecondValue()
    {
        return secondValue;
    }

    // ...
}