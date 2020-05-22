package exe;

import java.net.*;
import jar_1.ClassInJar1;

public class myMain {
    public static void main(String[] args) {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        URL[] urls = ((URLClassLoader) cl).getURLs();
        for (URL url : urls) {
            System.out.println(url.getFile());
        }
        ClassInJar1.method();
    }
}