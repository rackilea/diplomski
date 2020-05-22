package Foo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestClass {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost");
        HttpURLConnection c = (HttpURLConnection)url.openConnection();
        c.connect();
    }
}