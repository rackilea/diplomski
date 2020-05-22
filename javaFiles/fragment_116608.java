public class MyPanel extends JPanel {

    // status used for drawing, can be anything you want, but let's say you need to know if the mouse is pressed.
    private boolean isMousePressed;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // do your stuff here, using isMousePressed
    }

    public void setMousePressed(boolean pressed) {
        isMousePressed= pressed;
    }
}