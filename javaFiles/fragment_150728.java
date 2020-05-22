// imports here

public class DrawingPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private List<Rect2> rectList = new ArrayList<>();

    // ..... more code

    public void addRect2(Rect2 rect) {
        rectList.add(rect);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // iterate through the rectList and draw all the Rectangles
        for (Rect2 rect : rectList) {
            rect.draw(g);
        }
    }

    // ...... more code

}