public class MyObject implements java.io.Serializable
{
    String name;
    ArrayList attributes;
    public MyObject(String name)
    {
       this.name = name;
    }
    public void addAttribute(String attr)
    {
        this.attributes.add(attr);
    }
}