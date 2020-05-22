comboBox.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() 
    {
        public void keyPressed(KeyEvent evt)
        {
            if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            {
                System.out.println("Pressed");
            }
        }
    });