@Root
public class Example
{
    @Attribute(name="index", required=true)
    private int index;
    @Element(name="text", required=true)
    private String text;


    public Example(int index, String text)
    {
        this.index = index;
        this.text = text;
    }


    // ...

}