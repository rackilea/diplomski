private BufferedImage changeColor(BufferedImage image, int srcColor, int replaceColor)
{
    BufferedImage destImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = destImage.createGraphics();
    g.drawImage(image, null, 0, 0);
    g.dispose();


    for (int width = 0; width < image.getWidth(); width++)
    {
        for (int height = 0; height < image.getHeight(); height++)
        {

           if (destImage.getRGB(width, height) == srcColor)
            {
               destImage.setRGB(width, height, replaceColor);
            }

        }
    }

    return destImage;
}