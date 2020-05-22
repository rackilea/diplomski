final class SerializationWrapper implements Serializable {

  private final static Kryo KRYO = new Kryo();
  private Object object;

  public SerializationWrapper(Object object) {
    this.object = object;
  }

  private void readObject(ObjectInputStream objectInputStream) 
      throws IOException, ClassNotFoundException {
    Input input = new Input(objectInputStream);
    object = KRYO.readClassAndObject(input);
    input.close();
  }

  private void writeObject(ObjectOutputStream objectOutputStream) 
      throws IOException {
    Output output = new Output(objectOutputStream);
    KRYO.writeClassAndObject(output, object);
    output.close();
  }

  public Object getWrappedObject() {
    return object;
  }
}