class JPT extends JPanel implements Runnable
{
    JPT()
    {
        new Thread(this).start();
    }

    public void run()
    {
        // Code to run in new thread here.
    }
}