public class MyApp_ServiceManagement
{
    static boolean isMsgToDisplay = false;

    /////////////////////////////
    public static boolean serviceInit()
    {
        (new Thread()
        {
            public void run()
            {
                for(int i=0;i < 6;i++)
                {
                     try { sleep(5*1000); }
                     catch(Exception ex) {}

                     isMsgToDisplay = true;
                }
            }
        }).start();

        return true;
    }

    /// is Data ready to be send to the UI ?
    public static boolean serviceIsDataForUI()
    {
        return isMsgToDisplay;
    }

    /// Data to be send to the UI
    public static Serializable serviceDataForUI()
    {
        isMsgToDisplay = false;
        return "hello, I am an interactive Service";
    }
}