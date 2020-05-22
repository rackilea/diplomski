public class Wrapper implements Serializable {
    private static final long serialVersionUID = 889826451319869803L;
    private transient Object wrapped;

    public Wrapper() {

    }

    public Wrapper(Object wrapped) {
        this.wrapped = wrapped;
    }

    private void writeObject(java.io.ObjectOutputStream stream) throws IOException {
        Kryo kryo = new Kryo();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Output output = new Output(bos);
        kryo.writeObject(output, wrapped);
        output.close();
        stream.writeObject(bos.toByteArray());
    }

    private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
        Kryo kryo = new Kryo();
        byte[] bytes = (byte[]) stream.readObject();
        ByteArrayInputStream bis = new ByteInputStream(bytes, bytes.length);
        Input input = new Input(bis);
        wrapped = kryo.readObject(input, LazyMap.class);
        input.close();
    }
}