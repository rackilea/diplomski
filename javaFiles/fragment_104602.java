public class MyClass() {

    private static String staticField1;
    private static String staticField2;

    static {
        load();
    }

    private static void saveField(String fieldName, Object fieldValue) throws IOException {
      FileOutputStream fos = new FileOutputStream(new File("MyClass-" + fieldName + ".dat"));
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(fieldValue);
      oos.close();
    }


    private static Object readField(String fieldName) throws IOException {
      FileInputStream fis = new FileInputStream(new File("MyClass-" + fieldName + ".dat"));
      ObjectInputStream ois = new ObjectInputStream(fis);
      Object value = ois.readObject();
      ois.close();

      return value;
    }

    private static void save() throws IOException {
      saveField("staticField1", staticField1);
      saveField("staticField2", staticField2);
    }

    private static void load() throws IOException {
      staticField1 = (String)readField("staticField1");
      staticField2 = (String)readField("staticField2");
    }

}