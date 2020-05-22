public class MultithreadedUserInput
{
    public static void main(String[] args)
    {
        InputDetector detector = new InputDetector();
        detector.start();

    for (int i = 0; i < 1000000; i++)
    {
        System.out.println(i);

        if (detector.getInput().equals("exit"))
        {
            break;
        }
    }

    //do something after user types exit
    }
}