//create a JComponent to store your image 
 class ImagePanel extends JComponent
 {
private Image image;
public ImagePanel(String str) {
    BufferedImage image=null;
    try {
        image = ImageIO.read(new File(str));
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    this.image = image;
}
@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(image, 0, 0, this);
}
}

//in your JFrame class
ImagePanel contentPane = new ImagePanel("./background.png");
this.setContentPane(contentPane);
getContentPane().setBackground(Color.LIGHT_GRAY);// just in case your image does not fit the entire view