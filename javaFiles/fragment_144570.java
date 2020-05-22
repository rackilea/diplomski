public void moveRec(KeyEvent evt){
    switch(evt.getKeyCode()){
        case KeyEvent.VK_LEFT:
            System.out.println("test");
            dx -= 2;
            rec.setRect(dx, dy, 30, 10);
            Graphics g = getGraphics();
            paintComponent(g);
            break;
        case KeyEvent.VK_RIGHT:
            dx += 2;
            rec.setRect(dx, dy, 30, 10);
            Graphics g = getGraphics();
            paintComponent(g);
            break;
    }
}