for(String image : images){
        BufferedImage bi = ImageIO.read(new File(image));
        g.drawImage(bi, x, y, null);
        x += 256;
        if(x > result.getWidth()){
            x = 0;
            y += bi.getHeight();
        }
    }