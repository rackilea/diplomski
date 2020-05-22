public class Input extends SomeClass implements AutoCloseable {
    public Input(File source) throws FileNotFoundException {
        this(new FileInputStream(source));
    }
    @Override 
    public void close() {
        someMethodThatClosesInnerResource();
    }
}