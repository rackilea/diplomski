public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ENTER) {
            Object which = JFrame.getFocusOwner();                
            if(which.getClass() == JTextField.class)
                foo(which);
         }
    }

    public void mouseClicked(MouseEvent e) {                
        Object which = e.getSource();
        if(which.getClass()== JTextField.class) {
            foo(which);
        }
    }