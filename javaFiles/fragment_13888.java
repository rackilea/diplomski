abstract public class Item
{
    static protected Map<Class<?>, Byte> indexes=new HashMap<Class<?>,Byte>();
    public byte getIndex() {
      return Item.indexes.get(this.getClass());
    }
}

public class Depot extends Item
{
    public static final byte INDEX = 18;
    static {
      Item.indexes.put(Depot.class, Depot.INDEX);
    }
}