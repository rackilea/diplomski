public class Key implements KeyListener {
    private Ball ball;

    public Key(Ball ball) {
        this.ball = ball;
    }

    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_W){
            b.incrX(10); // give Ball a public method for this
            b.repaint();
            // System.out.println("x: " + super.x);
        }
    }

    // .... etc...