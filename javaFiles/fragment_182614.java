public void go() 
{

        gooPanel.repaint();
        try 
        {
            Thread.sleep(frameTimeInMillis);
        } catch (InterruptedException e) {}

}