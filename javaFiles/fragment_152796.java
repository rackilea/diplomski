public class MiniGraphicTest extends JPanel {

    private static final long serialVersionUID = 1L;

    public int x, y;
    boolean flag;

    public MiniGraphicTest() {
        super();
        x = -1;
        y = -1;
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent m) {
                x = m.getX() - 25;
                y = m.getY() - 25;
                if(flag) {
                    repaint(100, 100, 100, 100);
                } else {
                    repaint(200, 200, 100, 100);
                }
                flag = !flag;
            }
        });
    }
    // Other codes of yours
}