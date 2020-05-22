public Image thresholdWhite(Image in, int threshold)
{
    Pixel[][] pixels = in.getPixels();
    for(int i = 0; i < pixels.length; ++i)
    {
        for(int j = 0; j < pixels[i].length; ++j)
        {
            byte red = pixels[i][j].getRed();
            byte green = pixels[i][j].getGreen();
            byte blue = pixels[i][j].getBlue();
            /* In case it isn't a grayscale image, if it is grayscale this if can be removed (the block is still needed though) */
            if(Math.abs(red - green) >= 16 && Math.abs(red - blue) >= 16 && Math.abs(blue- green) >= 16)
            {
                if(red >= threshold || blue >= threshold || green >= threshold)
                {
                    pixels[i][j] = new Pixel(Colors.WHITE);
                }
            }
        }
    }
    return new Image(pixels);
}