public class Item implements java.io.Serializable{
  ....
}

{
  Item item=new Item();
  ObjectInputStream stream=new ObjectInputStream(fileStream);
  stream.write(item);
}