SwingUtilities.invokeLater(new Runnable()
{
    public void run()
    {
        jScrollPane2.getHorizontalScrollBar().getModel().setValue(10);
    }
});