import java.util.*;
import java.io.*;

public class test {
    public static void main(String [] args) {
        Properties p = new Properties();

        p.setProperty("z", "z value");
        p.setProperty("i", "i value");

        Properties pp = new Properties(p);
        pp.setProperty("i", "some other value");

        System.out.println(p.getProperty("z"));
        System.out.println(p.getProperty("i"));
        System.out.println(pp.getProperty("z"));
        System.out.println(pp.getProperty("i"));
    }
}