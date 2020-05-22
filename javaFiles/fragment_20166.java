protected void paintComponent(Graphics g) 
{
    BufferedImage bufferedImage = new BufferedImage(500, 500, BufferedImage.TYPE_ARGB);
    Graphics2D g2d = bufferedImage.createGraphics();
    //paint using g2d ...

    Graphics2D g2dComponent = (Graphics2D) g;
    g2dComponent.drawImage(bufferedImage, null, 0, 0);  
}