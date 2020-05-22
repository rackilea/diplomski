private class MyThread extends Thread
{
    public boolean bRun = true;

    @Override
    public void run()
    {
        try
        {
            sleep(3200);
            if (bRun)
            {
                startActivity(new Intent(getApplicationContext(), Activity2.class));
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}