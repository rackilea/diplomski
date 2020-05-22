text.addKeyListener(new KeyAdapter() {
        public void keyReleased(KeyEvent evt) {
            if(evt.getKeyCode() == KeyEvent.VK_1||evt.getKeyCode() == KeyEvent.VK_2||evt.getKeyCode() == KeyEvent.VK_3||evt.getKeyCode() == KeyEvent.VK_4||evt.getKeyCode() == KeyEvent.VK_5||evt.getKeyCode() == KeyEvent.VK_6||evt.getKeyCode() == KeyEvent.VK_7||evt.getKeyCode() == KeyEvent.VK_9||evt.getKeyCode() == KeyEvent.VK_COLON||evt.getKeyCode() == KeyEvent.VK_BACK_SPACE                           ) {
                double result = Double.parseDouble(text.getText());

                if("ftFIELD".equals(name)) {
                    textField2.setText("" + result/3.2808);
                }
                else if("mFIELD".equals(name)) {
                    textField2.setText("" + result*3.2808);
                }
            }
        }
    });