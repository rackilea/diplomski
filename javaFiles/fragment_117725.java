import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        StringWriter writer = new StringWriter();
        Properties props = new Properties();
        props.setProperty("key", "value!");
        props.store(writer, "Demo");
        System.out.println(writer);
    }
}