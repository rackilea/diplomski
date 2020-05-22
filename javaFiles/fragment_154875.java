public class Program
{   
    int numOfGuesses; // member variable

    public void run()
    {
        System.out.println(numOfGuesses);
    }

    public static void main(String[] args)
    {
        new Program().run();
    }
}