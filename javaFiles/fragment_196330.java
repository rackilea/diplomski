JFormattedTextField textField = new JFormattedTextField();
textField.addKeyListener(new KeyAdapter() {
@Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        char c = e.getKeyChar();

        if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
            Toolkit.getDefaultToolkit().beep();
            e.consume();
        }
    }