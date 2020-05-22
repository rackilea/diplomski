import java.util.Scanner;

public class InputDetector implements Runnable
{
    private Thread thread;
    private String input;
    private Scanner scan;

    public InputDetector()
    {
        input = "";
        scan = new Scanner(System.in);
    }

    public void start()
    {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run()
    {
        while (!(input.equals("exit")))
        {
            input = scan.nextLine();
        }
    }

    public String getInput()
    {
        return input;
    }
}