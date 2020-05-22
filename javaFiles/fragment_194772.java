public class PayloadSerializer implements org.apache.kafka.common.serialization.Serializer {

    public void configure(Map map, boolean b) {

    }

    public byte[] serialize(String s, Object o) {

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

    public void close() {

    }
}