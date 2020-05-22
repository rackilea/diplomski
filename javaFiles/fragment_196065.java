public class Input extends SomeClass implements AutoCloseable {
    public static Input createInput(File source) throws Exception {
        FileInputStream inputstream = new FileInputStream(source);
        try {
            return new Input(inputstream);
        } catch (Exception e) {
            inputstream.close();
            throw e;
        }
    }
    private Input(FileInputStream source)  {
        this(source);
    }
    @Override 
    public void close() {
        someMethodThatClosesInnerResource();
    }
}