public class Foo {
    public static Path doGet(File f) throws IOException {
        try {
            return Paths.get(f.getCanonicalPath());
        } catch (InvalidPathException e) {
            return null;
        }
    }
}