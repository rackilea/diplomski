public class TimeTableGraphicsRunner extends JFrame implements ComponentListener
{
    public TimeTableGraphicsRunner()
    {
        addComponentListener(this);
        ... snip
    }

    ... snip

    public void componentShown(ComponentEvent e) {
        grabScreenShot();
        System.out.println("Cleaning up");
        setVisible(false);
        System.out.println("Finished");
        System.exit(0);
    }
}