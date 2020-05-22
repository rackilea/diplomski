public ImageIcon resizeImage(String filePath, int w, int h) {


        String data = filePath;
        BufferedImage bsrc, bdest;
        ImageIcon theIcon;

//scale the image
        try
        {

            bsrc = ImageIO.read(new File(data));

            bdest = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bdest.createGraphics();
            AffineTransform at = AffineTransform.getScaleInstance((double) w / bsrc.getWidth(),
                    (double) h / bsrc.getHeight());
            g.drawRenderedImage(bsrc, at);

            //add the scaled image
            theIcon = new ImageIcon(bdest);
            return theIcon;
        }
        catch (Exception e)
        {
            System.out.println("This image can not be resized. Please check the path and type of file.");
            return null;
        }

     }