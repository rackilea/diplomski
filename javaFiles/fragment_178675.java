SwingUtilities.invokeLater(new Runnable()
{
    public void run()
    {
        model.removeRow(e.getFirstRow());
    }
});