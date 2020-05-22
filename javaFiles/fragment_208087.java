public class Test {
    public static void main(String[] args) {
        String s;

        // this compiles
        s = new Generic<Object>().get();
        // so does this
        s = new Generic<Object>().<String>get();

        // this doesn't compile
        s = new Generic().get();
        // neither does this
        s = new Generic().<String>get();
    }
}

class Generic<A> {
    <B> B get() { return null; }
}