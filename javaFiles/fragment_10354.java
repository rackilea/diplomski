private void processKeys(){
    KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(
        new KeyEventDispatcher()  { 
            public boolean dispatchKeyEvent(KeyEvent e){
                if(e.getID() == KeyEvent.KEY_PRESSED){
                    handleKeyPress(e.getKeyCode());
                    if(areThingsInPlace() && !dialogShown){
                        dialogShown = true;
                        JOptionPane.showMessageDialog(null,"Congratulations!!! YOU WIN!!");
                        System.exit(1);
                    }
                }
                return false;
            } 
    });
}