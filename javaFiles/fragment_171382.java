import java.util.*;
import java.util.regex.*;
import java.lang.reflect.*;

public class T2 {

    public static void main(String[] args) throws Exception {
      String String = "abc";
      outputAll((String instanceof java.lang.String), String);
    }

    public static void outputAll(Object... args) {
      System.out.println();
      for (Object o: args) {
        System.out.println(o);
      }
    }

    public static void output(String msg, Object... args) {
      System.out.println(String.format(msg, args));
    }
}