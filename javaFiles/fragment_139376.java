SwingUtilities.invokeLater(new Runnable() 
{
    @Override
    public void run() 
    {
        AccessClass testClass = new AccessClass(AccessMain.this); //fixed this
        testClass.setVisible(true);
    }
});