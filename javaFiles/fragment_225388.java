int lastKey = -1;

public void keyPressed(KeyEvent arg0) {
    // TODO Auto-generated method stub
    int codigo = arg0.getKeyCode();
    if (codigo != lastkey) {
        lastkey = codigo
        if(codigo == KeyEvent.VK_SPACE)
        {
           keyPressedMillis = System.currentTimeMillis();           
        }
    }
}