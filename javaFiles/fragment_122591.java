public class ConvertMapToBytes {

    public static void main(String[] args) {
        Map<Long, CustomObject> map = new HashMap<Long, CustomObject>();

        CustomObject c = new CustomObject();
        c.age = 20;
        c.name = "name";

        CustomObject c2 = new CustomObject();

        map.put(1L, c);
        map.put(2L, c2);

        try {
            byte[] bytes = convertMap(map);

            System.out.println("got bytes");

            // deserialise
            Map<Long, CustomObject> map2 = convertBytes(bytes);
            for (CustomObject co : map2.values()) {
                System.out.println(co);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static byte[] convertMap(Map<Long, CustomObject> map) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        new ObjectOutputStream(baos).writeObject(map);
        return baos.toByteArray();
    }

    @SuppressWarnings("unchecked")
    public static Map<Long, CustomObject> convertBytes(byte[] obj) throws Exception {
        return (Map<Long, CustomObject>)new ObjectInputStream(new ByteArrayInputStream(obj)).readObject();
    }

}

class CustomObject implements Serializable {
    private static final long serialVersionUID = 1L;

    public String name = "John";
    public int age = 14;

    @Override
    public String toString() {
        return "name: " + name + ", age: " + age;
    }
}