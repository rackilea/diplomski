import java.net.URL;

class URLTest {

    public static void main(String[] args) throws Exception {
        URL url = new URL("jar:file:/C:/baz.jar!/COM/foo/Quux.class");
        System.out.println(url);
        System.out.println(url.getPath());
    }
}