class StarterClass {
    public static void main(String[] args)
    {
        // start XPlayer thread
        try
        {
            XPlayer x = new XPlayer();
            Thread t = new Thread(x);
            t.start();

        } catch(IOException ioe)
        {
            System.err.println
                ("IOE IN XPLAYER MAIN " + ioe.getMessage());
            System.exit(1);
        }

        // start OPlayer thread
        try
        {
            OPlayer o = new OPlayer();
            Thread t = new Thread(o);
            t.start();

        } catch(IOException ioe)
        {
            System.err.println("IOE IN OPLAYER MAIN" + ioe.getMessage());
            System.exit(1);
        }
    }
}