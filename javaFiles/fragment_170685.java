public void postListen()
{
    new Thread(new Runnable()
    {
        public void run()
        {
            connect_clients();
        }

    }).start();
}