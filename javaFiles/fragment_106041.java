public class CustomSerializer implements Encoder<Notification>, Decoder<Notification> {
    public CustomSerializer(VerifiableProperties verifiableProperties) {
        /* This constructor must be present for successful compile. */
    }

@Override
public byte[] toBytes(Notification o) {
    try {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(o);
        oos.close();
        byte[] b = baos.toByteArray();
        return b;
    } catch (IOException e) {
        return new byte[0];
    }
}

@Override
public Notification fromBytes(byte[] bytes) {
    try {
        return (Notification) new ObjectInputStream(new ByteArrayInputStream(b)).readObject();
    } catch (Exception e) {
        return null;
    }    
}