for(int i = 1; i <= 35; i++)
{
    rColor = new Color(rGen.nextInt(256),rGen.nextInt(256),
            rGen.nextInt(256));
    g.setColor(rColor);
    x1 = num.nextInt(x-50) + 10;
    x2 = num.nextInt(50) + 10;
    y1 = num.nextInt(y-50) + 10;
    y2 = num.nextInt(50) + 10;
    g.drawRect(x1, y1, x2, y2);
}