public class SimpleKeyListener implements KeyListener {

    StringBuilder sb = new StringBuilder();

    @Override
    public void keyTyped(KeyEvent e) {
        sb.append(e.getKeyChar());
        System.out.println(sb.toString());
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("UP");
        } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("DOWN");
        }
    }
}