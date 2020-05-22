public static BufferedImage andImage(BufferedImage one, BufferedImage two)
{  
    BufferedImage result = new BufferedImage(one.getWidth(), one.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
    result.getGraphics().drawImage(one, 0, 0, null);
    WritableRaster rasterOne = result.getRaster();
    WritableRaster rasterTwo = two.getRaster();

    int[] pixelsOne = new int[one.getWidth()];
    int[] pixelsTwo = new int[two.getWidth()];

    for (int y = 0; y < two.getHeight(); y++) 
    {
        rasterOne.getPixels(0, y, one.getWidth(), 1, pixelsOne);
        rasterTwo.getPixels(0, y, two.getWidth(), 1, pixelsTwo);

        for (int i = 0; i < pixelsOne.length; i++) 
        {
            if (pixelsTwo[i] == 0 && pixelsOne[i] == 0)
                pixelsOne[i] = 0;
            else 
                pixelsOne[i] = 255;
        }
        rasterOne.setPixels(0, y, one.getWidth(), 1, pixelsOne);
    }

    return result;
}