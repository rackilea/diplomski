public class TestSerialisation {

    public static void main(String[] args) {
        new TestSerialisation();
    }

    public TestSerialisation() {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        Wrapper out = new Wrapper();
        System.out.println("Before = " + out.dump());
        try {
            try {
                oos = new ObjectOutputStream(new FileOutputStream(new File("Test.out")));
                oos.writeObject(out);
            } finally {
                try {
                    oos.close();
                } catch (Exception e) {
                }
            }

            Wrapper in = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(new File("Test.out")));
                in = (Wrapper) ois.readObject();
            } finally {
                try {
                    ois.close();
                } catch (Exception e) {
                }
            }            
            System.out.println("After = " + (in == null ? "null" : in.dump()));            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static class Wrapper implements Serializable {

        private JTextArea textArea;

        public Wrapper() {
            textArea = new JTextArea("I'm some text");
        }

        public String dump() {
            return textArea.getText();
        }
    }
}