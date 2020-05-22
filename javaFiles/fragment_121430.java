private static void outputString(Robot robot,String str)
{
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    boolean numlockOn = toolkit.getLockingKeyState(KeyEvent.VK_NUM_LOCK);

    int[] keyz=
    {
            KeyEvent.VK_NUMPAD0,
            KeyEvent.VK_NUMPAD1,
            KeyEvent.VK_NUMPAD2,
            KeyEvent.VK_NUMPAD3,
            KeyEvent.VK_NUMPAD4,
            KeyEvent.VK_NUMPAD5,
            KeyEvent.VK_NUMPAD6,
            KeyEvent.VK_NUMPAD7,
            KeyEvent.VK_NUMPAD8,
            KeyEvent.VK_NUMPAD9
    };

    if(!numlockOn)
    {
        robot.keyPress(KeyEvent.VK_NUM_LOCK);
    }

    for(int i=0;i<str.length();i++)
    {
        int ch=(int)str.charAt(i);
        String chStr=""+ch;
        if(ch <= 999)
        {
            chStr="0"+chStr;
        }           
        robot.keyPress(KeyEvent.VK_ALT);                    
        for(int c=0;c<chStr.length();c++)
        {               
            int iKey=(int)(chStr.charAt(c)-'0');
            robot.keyPress(keyz[iKey]);             
            robot.keyRelease(keyz[iKey]);               
        }
        robot.keyRelease(KeyEvent.VK_ALT);
    }       

    if(!numlockOn)
    {
        robot.keyPress(KeyEvent.VK_NUM_LOCK);
    }       
}