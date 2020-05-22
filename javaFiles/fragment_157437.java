public class A {
    private String foo;

    @Override
    public String toString() {
        // When you print out instance of A, value of its foo
        // field will be printed out
        return foo;
    }
}