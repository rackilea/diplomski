BufferedImage bim = pdxObjectImage.getRGBImage();

boolean bwImage = true;

int w = bim.getWidth();
int h = bim.getHeight();
for (int y = 0; y < h; y++)
{
    for (int x = 0; x < w; x++)
    {
        Color c = new Color(bim.getRGB(x, y));
        int red = c.getRed();
        int green = c.getGreen();
        int blue = c.getBlue();
        if (red == 0 && green == 0 && blue == 0)
        {
            continue;
        }
        if (red == 255 && green == 255 && blue == 255)
        {
            continue;
        }
        bwImage = false;
        break;
    }
    if (!bwImage)
        break;
}
System.out.println(bwImage);