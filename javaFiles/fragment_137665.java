class MyKeyListener extends KeyAdapter{
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode()== KeyEvent.VK_Q)
            System.out.println("Key Q pressed!");
    }
}