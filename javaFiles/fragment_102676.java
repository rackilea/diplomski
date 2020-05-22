class MyMetadata
{
    private int x;
    private int y;
    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public void setX(int newX) { this.x = x; }
    public void setY(int newY) { this.y = y; }
    MyMetadata(int x, int y) { this.x = x; this.y = y; }

    static final private MyMetadata INSTANCE = new MyMetadata(0,0);
    static public MyMetadata getInstance() { return INSTANCE; }
}

// in client code:
int needsX = MyMetadata.getInstance().getX();