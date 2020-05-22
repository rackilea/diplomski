final Object monitor = new Object();

class Drawing implements Runnable
{
    @override
    void run()
    {
        while(true)
        {

            synchronized(monitor)
            {
                monitor.wait();
            }

            // draw
        }
    }
}

public static void main(String[] args) {

    // start your thread
    while(true)
    {
        if( needRefresh )
        {
            synchronized(monitor)
            {
                monitor.notify();
            }
        }
    }
}