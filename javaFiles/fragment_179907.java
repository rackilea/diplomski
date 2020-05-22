addWindowListener(new java.awt.event.WindowAdapter()
{
    @Override
    public void windowClosing(java.awt.event.WindowEvent evt)
    {
        try
        {
            document.close();
        }
        catch (IOException ex)
        {
        }
    }
});