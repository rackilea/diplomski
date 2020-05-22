public static void closeCall()
{
    Long exitTime = Calendar.getInstance().getTime().getTime() + 5 * 1000;
    for(int i=1; i>0; i++)
    {
        Long currentTime = Calendar.getInstance().getTime().getTime();
        if (currentTime >= exitTime)
        {
            JFrame1.dispatchEvent(new WindowEvent(JFrame1, WindowEvent.WINDOW_CLOSING));
            System.exit(0);
            break;
        }        
    }
}