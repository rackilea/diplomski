public class Test {

    public Object doSomething(String source) throws IOException {
        try (InputStream is = openAsStream(source)) {
            // ... read and process stuff
            return ...
        }
    }

    public InputStream openAsStream(String name) throws IOException {
        String fileName = // ... do something with 'name'
        return new FileInputStream(name);
    }

    public static void main(String[] args) {
        // ...
        Test t = new Test();
        try {
            t.doSomething(args[0]);
        } catch (IOException ex) {
            System.err.println("Cannot handle '" + args[0] + "'");
        }
    }
}