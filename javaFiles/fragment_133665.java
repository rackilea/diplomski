public void run()
{
    while(true)
    {
        try
        {
            Thread.sleep(5000);
        }
        catch(Exception e) {}

        _panel.createLines();
    }
}