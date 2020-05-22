SwingUtilities.invokeLater(new Runnable()
{
    public void run()
    {
        if (code.getDocument().getLength() >= 13)
        {                  
            code.setText("");                
        }
    }
});