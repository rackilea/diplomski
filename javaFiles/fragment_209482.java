public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();
    switch( code ) { 
        case KeyEvent.VK_UP:
            // handle up 
            System.out.println(code);
            break;
        case KeyEvent.VK_DOWN:
            // handle down 
            break;
        case KeyEvent.VK_LEFT:
            // handle left
            break;
        case KeyEvent.VK_RIGHT :
            // handle right
            break;
     }
}