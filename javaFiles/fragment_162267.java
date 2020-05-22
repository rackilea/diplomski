private class textChangedListener implements KeyListener 
{
    public void keyPressed(KeyEvent e){} 
    public void keyReleased(KeyEvent e){}

    public void keyTyped(KeyEvent e) 
    {
        System.out.print(textField1.getText());
    } 
}