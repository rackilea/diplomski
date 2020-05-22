public class SampleInterfaceContainer {
    private SampleInterface content;
    private String name;
    public SampleInterfaceContainer(String name, SampleInterface content)
    {
        this.name = name;
        this.content = content;
    }

    public String getName()
    {
        return this.name;
    }

    public SampleInterface getContent()
    {
        return this.content;
    }
}
public interface SampleInterface {
    int getNumber();
}
public class SampleImplementation1 implements SampleInterface{
    private int number;
    public SampleImplementation1()
    {
        this.number = 0;
    }
    public SampleImplementation1(int number)
    {
        this.number = number;
    }
    public int getNumber()
    {
        return this.number;
    }
}

public class SampleImplementation2 implements SampleInterface{
    private  int number;
    private String name;
    public SampleInterfaceContainer Container;
    public SampleImplementation2()
    {
        this.number = 0;
        this.name = "";
    }
    public SampleImplementation2(int number, String name)
    {
        this.number = number;
        this.name = name;
    }
    public int getNumber()
    {
        return this.number;
    }
    public String getName()
    {
        return this.name;
    }
}