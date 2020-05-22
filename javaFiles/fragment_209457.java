public class MyKryoRegistrator implements KryoRegistrator, Serializable {
  @Override
  public void registerClasses(Kryo kryo) {
      // Product POJO associated to a product Row from the DataFrame      
      kryo.register(MyRecord.class);  
  }
}