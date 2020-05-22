class Addr
{
    private byte foo;
    private short bar;
    public final static int bufferBytes = 3;

    public int getUnsignedFoo()
    {
        return (int)foo & 0xff;
    }
    public int getUnsignedBar()
    {
        return (int)bar & 0xffff;
    }
}