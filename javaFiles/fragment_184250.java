public void mouseClicked(MouseEvent me) {
    Point clicked = me.getPoint();
    Rectangle bounds = new Rectangle(250, 250, target.getWidth(), target.getHeight());
    if (bounds.contains(clicked)) {
        // target image was clicked
    }
}