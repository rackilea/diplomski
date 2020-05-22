JTextArea ta = new JTextArea();
ta.addKeyListener(new KeyAdapter() {
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed, warn the user that this is read only!");
    }
});