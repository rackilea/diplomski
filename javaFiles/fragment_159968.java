// Assuming equal-sized images:
for (int y=0; y<imageA.getHeight(); y++)
{
    for (int x=0; x<imageA.getWidth(); x++)
    {
        int rgbA = imageA.getRGB(x,y);
        int rgbB = imageB.getRGB(x,y);
        if (rgbA != rgbB) 
        { 
            // Images are NOT equal!
        }
    }
}