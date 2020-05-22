package stackoverflow;

import java.net.URL;
import java.net.URLClassLoader;

public class PrintClassLoader {
    public static void main(String[] args) {
        PrintClassLoader pcl = new PrintClassLoader();
        pcl.printClassLoader(pcl.getClass().getClassLoader());
    }

    public void printClassLoader(ClassLoader classLoader) {
        if (null == classLoader) {
            return;
        }
        System.out.println("--------------------");
        System.out.println(classLoader);
        if (classLoader instanceof URLClassLoader) {
            URLClassLoader ucl = (URLClassLoader) classLoader;
            int i = 0;
            for (URL url : ucl.getURLs()) {
                System.out.println("url[" + (i++) + "]=" + url);
            }
        }
        printClassLoader(classLoader.getParent());
    }
}