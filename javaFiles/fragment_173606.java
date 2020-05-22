private final int ALPHA = 24;
private final int RED = 16;
private final int GREEN = 8;
private final int BLUE = 0;

public int[] getRGBA(BufferedImage img, int x, int y)
{   
    int[] color = new int[4];
    color[0]=getColor(img, x,y,RED);
    color[1]=getColor(img, x,y,GREEN);
    color[2]=getColor(img, x,y,BLUE);
    color[3]=getColor(img, x,y,ALPHA);
    return color;
}

public int getColor(int x, int y, int color)
{       
    int value=img.getRGBA(x, y) >> color & 0xff;
    return value;
}