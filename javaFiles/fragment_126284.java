BufferedImage img=ImageIO.read(new File(....));
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
double screen_width = screenSize.getWidth();
double screen_height = screenSize.getHeight();
double scalex=screen_width/img.getWidth(), scaley=screen_height/img.getHeight();
double scale=Math.min(scalex, scaley);
int w=(int)(scale*img.getWidth()), h=(int)(scale*img.getHeight());
BufferedImage img2=new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
img2.getGraphics().drawImage(img, 0, 0, w, h, null);