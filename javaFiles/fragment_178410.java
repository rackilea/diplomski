interface MyCloneableInterface<T> {
  T duplicate(T object) throws CopyException;
}
public static <T> T copy(T data) throws CopyException  {
  if(data == null) return null;
  if(data instanceof MyCloneableInterface) {
    return ((MyCloneabeInterface)data).duplicate(data);
  }
  if(data instanceof Serializable) {
    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(baos);
      oos.writeObject(this);

      ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
      ObjectInputStream ois = new ObjectInputStream(bais);
      return (CloneExample) ois.readObject();
    }
    catch(...) {//rethrow}
  }
  if(data instanceof Cloneable) {
    try {
      return (T)data.clone();
    }
    catch(CloneNotSupportedException e) {//rethrow}
  }
  // else you can look for copy-constructor via reflection or
  // cloning object field-by-field via reflection...
}