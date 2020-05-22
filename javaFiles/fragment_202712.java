@JsonDeserialize(using = MyObjectDeserializer.class)
public class MyObject
{
    public int num;
    public String str;

    @Override
    public String toString()
    {
        return "{" + num + "," + str + "}";
    }
}