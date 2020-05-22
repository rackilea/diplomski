final Frame frame = new Frame();
frame.setVisible(true);

frame.addKeyListener(new KeyAdapter() {

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            // your code is scanned and you can access it using frame.getBarCode()
            // now clean the bar code so the next one can be read
            frame.setBarCode(new String());
        } else {
            // some character has been read, append it to your "barcode cache"
            frame.setBarCode(frame.getBarCode() + e.getKeyChar());
        }
    }

});