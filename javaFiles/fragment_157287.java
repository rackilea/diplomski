public void drawString(Graphics g, int x, int y, Object... args)
{
    org.newdawn.slick.Font font = g.getFont();
    int currentOffset = x;
    int startOffset = x;

    for (int i = 0; i < args.length / 2; i++)
    {
        g.setColor((Color) args[i * 2]);
        g.drawString((String) (args[i * 2 + 1]), currentOffset, y);

        currentOffset += font.getWidth(((String) (args[i * 2 + 1])));

        if (((String) (args[i * 2 + 1])).contains("\n"))
        {
            currentOffset = startOffset;
        }
    }
}