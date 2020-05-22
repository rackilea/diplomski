public class MyClass implements Runnable
{
    private String input  = null;
    private String output = null;

    public MyClass(String input)
    {
        this.input = input;
    }

    public String getOutput()
    {
        return output;
    }

    public void run()
    {
        output = func(input);
    }
}