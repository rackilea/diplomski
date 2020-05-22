// Like Consumer, but with an exception.
interface Use<R, EXC extends Exception> {
    void use(R resource) throws EXC;
}

public static void withThing(String name, Use<InputStream,IOException> use) throws IOException {
     try (InputStream in = new FileInputStream(name)) {
         use.use(in);
     }
}