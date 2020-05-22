@Override
public void paintComponent(Graphics g){
    Graphics2D g2d = (Graphics2D)g;
    BufferedImage img = ...;
    AffineTransform at = ...;
    g2d.drawImage(img, at, null);//null-param is the ImageObserver
    ....
}