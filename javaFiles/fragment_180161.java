public class OuterClass {
    private class PrivateInnerClass {
    }
    public void instantiate() {
        new PrivateInnerClass();
    }
}