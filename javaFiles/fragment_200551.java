public class Program
{
    private String foo;
    private String bar;

    public static void main(String[] args) 
    {
        Program program = new Program(args);
        program.run();
    }

    private Program(String[] args)
    {
        this.foo = args[0];
        this.bar = args[1];
        // etc
    }

    private void run()
    {
        // whatever
    }
}