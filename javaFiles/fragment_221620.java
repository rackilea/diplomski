FontMetrics fm = windowTemp.getFontMetrics();
int y = 50;
for(int i = 0; i<array.length; i++)
{
    windowTemp.drawString(array[i] + "", 10,y + fm.getAscent());
    y+=fm.getHeight();
}