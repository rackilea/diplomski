class NewRunnable implements Runnable
{
    public void run()
    {
        // Do important background stuff here
    }
}

public static void main (String[] args)
{
    Thread thr = new Thread ( new NewRunnable( ) ) ;
    thr.start( ) ;

    // Do other important stuff
}