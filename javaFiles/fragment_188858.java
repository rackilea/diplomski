private final static Field out;
{
    try {
        out = FilterInputStream.class.getField("out");
        out.setAccessible(true);
    } catch(Exception e) {
        throw new RuntimeException(e);
    }
}

public OutputStream recreateChainedOutputStream(OutputStream out) throws IOException {
    if (out instanceof FilterOutputStream) {
        Class<?> c = ou.getClass();
        COnstructor<?> con = c.getConstructor(OutputStream.class);
        return con.invoke(this.out.get(out));
    } else {
        // Other output streams...
    }
}