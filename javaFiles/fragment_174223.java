final String[] resultContainer = new String[1];
EventQueue.invokeAndWait(new Runnable()
{
    @Override public void run()
    {
        resultContainer[0] = JOptionPane.showInputDialog(null, "Choose a username:",
            "Username selection", JOptionPane.PLAIN_MESSAGE);
    }
});
String result = resultContainer[0];
// ... do something with result.