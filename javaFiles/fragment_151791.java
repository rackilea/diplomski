class MyImages extends Rectangle
{
    private ImageIcon image;  //personally, I prefer to use BufferedImage here

    public MyImages(int x, int y, int width, int height){
        setBounds(x, y, width, height);
    }

    //getters & setters for image not shown

    public void draw(Graphics g){
        g.drawImage(image.getImage(), x, y, width, height, null);
    }

    //Check if current image is selected:
    public boolean isSelected(int xCoord, int yCoord){
        return (this.contains(xCoord, yCoord))
    }
}