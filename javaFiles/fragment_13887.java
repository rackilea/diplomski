abstract public class Item
{
    abstract public byte getIndex();
}

public class Depot extends Item
{
    public byte getIndex() { return 18; }
//  public static final byte INDEX = 18;
}