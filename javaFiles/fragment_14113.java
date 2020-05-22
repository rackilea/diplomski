class ImageBackgroundPane extends JOptionPane
    {
         private BufferedImage img;

         public ImageBackgroundPane (BufferedImage image)
         {
            this.img = image;
         }

         @Override
         public void paint(Graphics g)
         {
           //Pick one of the two painting methods below.

           //Option 1:
           //Define the bounding region to paint based on image size.
           //Be careful, if the image is smaller than the JOptionPane size you
           //will see a solid white background where the image does not reach.
           g.drawImage(img, 0, 0, img.getWidth(), img.getHeight());

           //Option 2:
           //If the image can be guaranteed to be larger than the JOptionPane's size
           Dimension curSize = this.getSize();
           g.drawImage(img, 0, 0, curSize.width, curSize.height, null);


           //Make sure to paint all the other properties of Swing components.
           super.paint(g);
         }
    }