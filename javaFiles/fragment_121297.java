private Point clickPoint;
private Rectangle originalBounds;
//...
@Override
public void mousePressed(MouseEvent e) {
    if (hovering) {
        resizing = true;
        System.out.println("Starting to resize");
        clickPoint = e.getPoint();
        originalBounds = new Rectangle(shapes.get(currentIndex).getBounds());
    }
}