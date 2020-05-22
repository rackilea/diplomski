public static void main(String[] args) 
{
    String fileName = null;
    if (args.length >= 1) {
        fileName = args[0];
    }
    if (Singleton.sendSignal(fileName)) 
    {
        Frame.getFrame().open(fileName);

        // start the server in a thread so that main method can continue on
        new Thread()
        {
           public void run()
           {
                Singleton.checkInput();
           }
        }.start();
    }

    // do your other tasks.
}