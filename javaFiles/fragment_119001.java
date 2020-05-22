private static float getMaxFontSize(BaseFont bf, String text, int width)
{
    int textWidth = bf.getWidth(text);

    return (1000 * width) / textWidth;
}