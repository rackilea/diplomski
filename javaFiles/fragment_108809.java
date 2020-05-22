public void method1() throws IOException {
    try {
        throw new IOException();
    } catch (Exception e) { // e is not modified in catch => implicitly final
        throw e; //compiles OK
    }
}

//it works because method1 is semantically equivalent to method2:
public void method2() throws IOException {
    try {
        throw new IOException();
    } catch (final Exception e) {
        throw e;
    }
}

public void method3() throws IOException {
    try {
        throw new IOException("1");
    } catch (Exception e) {
        e = new IOException("2"); //e modified: not implicitly final any more
        throw e; //does not compile
    }
}