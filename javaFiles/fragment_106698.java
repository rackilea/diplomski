public void customKeyPressed(KeyEvent e){
    int c = e.getKeyCode();

    if(c == KeyEvent.VK_LEFT || c == AZERTY_LEFT){
        velX = -1;
        velY = 0;
    } else if(c == KeyEvent.VK_UP || c == AZERTY_UP){
        velX = 0;
        velY = -1;
    } else if(c == KeyEvent.VK_RIGHT || c == AZERTY_RIGHT){
        velX = 1;
        velY = 0;
    } else if (c == KeyEvent.VK_DOWN || c == AZERTY_DOWN) {
        velX = 0;
        velY = 1;
    } else
        System.out.println(e.getKeyChar() + " = " + c);
}