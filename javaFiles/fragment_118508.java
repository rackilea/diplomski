public class Paddle {
    private JFrame frame;
    private int paddle_y;
    public Paddle(JFrame frame) {
        this.frame = frame;
        this.paddle_y = 30; //Or whatever number you want
        frame.addMouseMotionListener(new MouseMotionListener() {
            public void mouseMoved(MouseEvent e) {
                Paddle.this.paddle_y = e.getY(); //When the mouse is moved, it will call on this function to change the Paddle.paddle_y variable.
            }

            public void mouseDragged(MouseEvent e){} //This reacts when the mouse is clicked, moved, then released.
    }
}