public void run()
{
    while(alive)
    {
        try
        {
            doUpdate();
            sleep(60*1000);
        }
        catch (InterruptedException ie) {
            alive = false;
        }
    }
}