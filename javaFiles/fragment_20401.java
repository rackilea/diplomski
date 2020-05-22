public class MyEmbeddedObject
{
    public MyDoubleEmbeddedObject           subThing1;
    private MyDoubleEmbeddedObject[]        subThings;
    public MyDoubleEmbeddedObject[]         getSubThings()
    {
        return this.subThings;
    }
    public void setSubThings(final MyDoubleEmbeddedObject[] value)
    {
        this.subThings = value;
    }
}