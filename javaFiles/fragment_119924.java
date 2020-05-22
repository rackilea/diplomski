import java.net.URL;
import java.net.URLClassLoader;
public static void urlsInClasspath () {

        ClassLoader cl = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader)cl).getURLs();

        for(URL url: urls){
            System.out.println(url.getFile());
        }

   }