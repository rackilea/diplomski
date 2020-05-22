int[] originalPixel =  getRGBA(img,0,0);
    for (int i=0;i<img.getWidth();i++)
    {
        for (int j=0;j<img.getHeight();j++)
        {
           int[] color1 =  getRGBA(img,i,j);
           if (originalPixel[0] == color1[0] && originalPixel[1] == color1[1] && originalPixel[2] == color1[2] && originalPixel[3] == color1[3]) {
               img.setRGB(i, j,Color.red.getRGB());
           } 
           else {
               img.setRGB(i, j,Color.yellow.getRGB());
           }
        }
    }