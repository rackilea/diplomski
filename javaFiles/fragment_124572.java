final String text = getText();
    SwingUtilities.invokeLater(new Runnable()
    {           
        @Override
        public void run()
        {
            appendText(text);                
        }
    });