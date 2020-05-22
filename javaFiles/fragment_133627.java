BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
for (int x=0; x<w; x++)
{
    for(int y=0; y<h; y++)
    {
        image.setRGB(x,y,rgbValueFor(x,y));
    }
}