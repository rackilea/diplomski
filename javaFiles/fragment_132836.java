BufferedImage old = getScreenShot();
            int w = old.getWidth();
            int h = old.getHeight();

            int newWidth = w/4;
            int newHeight = h/4;


            BufferedImage resized = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

             AffineTransform at = new AffineTransform();
            at.scale(0.25, 0.25);
            AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            resized = scaleOp.filter(old, resized);

            //TODO (remove)  for debugging the screencapture capability
            File outputfile = new File("C:/Users/Kevin/Desktop/imagetestmap/test.png");
            try {
                ImageIO.write(resized, "png", outputfile);
            } catch (IOException e) {
                e.printStackTrace();
            }