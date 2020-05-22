/**
     * Resizes the image
     * @param filePath File path to the image to resize
     * @param w Width of the image
     * @param h Height of the image
     * @return A resized image
     */
     public ImageIcon resizeImage(String filePath, int w, int h) {


        String data = filePath;
        BufferedImage bsrc, bdest;
        ImageIcon theIcon;
        //scale the image
        try
        {
            if(dataSource == DataTypeEnum.file)
            {
                bsrc = ImageIO.read(new File(data));
            }
            else
            {
                bsrc = ImageIO.read(new URL(filePath));
            }
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
            Window.getLogger().warning("This image can not be resized. Please check the path and type of file.");
            //restore the old background
            return null;
        }

     }