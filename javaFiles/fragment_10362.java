class ImageGalleryPanel extends JPanel{
    private Point rectPosition = null;
    private Dimension rectSize; //Set the size of the rect

    public void setRectPosition(Point p){
        rectPosition = p;
    }

    private void drawRect(Graphics g){
        if(rectPosition != null){
            g.drawRect(rectPosition.x, rectPosition.y, rectSize.width, rectSize.height);
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawRect(g);
    }
}