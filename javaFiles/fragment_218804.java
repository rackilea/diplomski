@SuppressWarnings("unchecked")
public final class Collection_CustomFieldSerializerBase {

  public static void deserialize(SerializationStreamReader streamReader,
      Collection instance) throws SerializationException {
    int size = streamReader.readInt();
    for (int i = 0; i < size; ++i) {
      Object obj = streamReader.readObject();
      instance.add(obj); //line 35
    }
  }