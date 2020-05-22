phonefield.addKeyListener(new KeyAdapter() {
    public void keyPressed(KeyEvent evt) {
    if(evt.getKeyCode() == evt.VK_ENTER){
        System.out.println("The numbers you enter are "+phoneField.getText());
    }
    }
});