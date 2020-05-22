public class MyApp_TaskbarManagement
{
    /// To show (or not) the icon in tray
    public static boolean taskIsShow()
    {
        return false;
    }

    /// Receive the message from Service
    public static void taskDataFromService(Serializable data)
    {
        JOptionPane.showMessageDialog(null, data);
    }

    /// descr of UI
    public static String[] taskGetInfo()
    {
        return new String[]
            {
                "UI part of Service"
            };
    }
}