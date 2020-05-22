abstract public class Item
{
    public byte getIndex() {
      // this will throw *at runtime* if the derived doesn't declare INDEX
      // And, as is, it's insensitive to whether or not the
      // INDEX is static or instance field (so you need to refine your
      // verifications - see the java.lang.reflect.Field)
      return this.getClass().getField("INDEX").getByte();
    }
}