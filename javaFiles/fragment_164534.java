for(int x = 0; x < width; x++)
{
    for(int y = 0; y < height; y++)
    {
        alphaArray[x][y] = isAlpha(bufferedImage, x, y);
    }
}