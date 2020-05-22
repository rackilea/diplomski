import java.lang.reflect.*;
import java.util.*;
public static Object nArray(int n) {
     int[]dim = new int [n];
     Arrays.fill(dim, n);
     return Array.newInstance(int.class,dim);
}