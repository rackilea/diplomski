public void test(int x, int y){ // Here x and y are the parameter thrown by mouseDragged() function
blur1 = displayImage; // blur1 is Image variable

blur2 = new BufferedImage(blur1.getWidth(this), blur1 //blur2 is BufferedImage Variable
    .getHeight(this), BufferedImage.TYPE_INT_RGB);
tst = blur2.createGraphics(); // tst is Graphics2D variable
tst.drawImage(blur1, 0, 0, this);
blur3 = new BufferedImage(blur1.getWidth(this), blur1 //blur3 is BufferedImage Variable
    .getHeight(this), BufferedImage.TYPE_INT_RGB);
float data[] = { 0.0625f, 0.125f, 0.0625f, 0.125f, 0.25f, 0.125f,
    0.0625f, 0.125f, 0.0625f };
Kernel kernel = new Kernel(3, 3, data);
ConvolveOp convolve = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP,
    null);
blur2 = OSC.getSubimage(x, y, 20, 20); // 20 is the size in pixels where the effect is applied
blur3 = OSC.getSubimage(x, y, 20, 20);
convolve.filter(blur2, blur3);    
  Graphics osg = OSC.getGraphics();
  osg.setColor(fillColor);
  osg.drawImage(blur3,x,y,null);
  osg.dispose();
  repaint();
}