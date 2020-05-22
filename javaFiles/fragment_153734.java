// run will be executed on the EDT
SwingUtilities.invokeLater(new Runnable()
{
    @Override
    public void run()
    {
        docTest.insertString(docTest.getLength(), "first string ", sas);
        docTest.insertString(docTest.getLength(), "second string\n", sas);
    }
});