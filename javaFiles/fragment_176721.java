public class JPanelMouseMotion extends JPanel implements MouseMotionListener {

    private static final long serialVersionUID = 1L;

    public JPanelMouseMotion() {
        super();
        addMouseMotionListener(this); // register this JPanel as a Listener
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println(e.getX() + " / " + e.getY());
    }

}