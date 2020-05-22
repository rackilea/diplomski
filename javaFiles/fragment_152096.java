BufferedImage image = ImageIO.read(file);
        Raster ras = image.getRaster();

        //Number of Color elements
        int elem = ras.getNumDataElements();

        int width = image.getWidth();
        int height = image.getHeight();

        int pixel,red, green, blue;

        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++) {
                //scan through each pixel
                pixel = image.getRGB(i, j);
                red = (pixel >> 16) & 0xff;
                green = (pixel >> 8) & 0xff;
                blue = (pixel) & 0xff;

                //check if R=G=B
                if (red != green || green != blue ) {
                    flag = true;
                    break;
                }


            }