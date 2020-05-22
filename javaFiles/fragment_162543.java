import javax.swing.JFrame;

public class JFrameInput
{
    public static void main(String[] args)
    {
        InputFrame iFrame = new InputFrame();
        iFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iFrame.pack();
        iFrame.setVisible(true);

        for (int i = 0; i < 1000000; i++)
        {
            System.out.println(i);
            if ((iFrame.getInput().equals("exit")))
            //if (iFrame.checkInput("exit"))    //use to exit without pressing enter
            {
                break;
            }
        }
        //do something after user types exit
    }
}