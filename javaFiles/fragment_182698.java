import java.util.Arrays;
import java.util.Collections;

public class MyArray {

    public static void name() {            
        String hello = "hello, world";
        char[] hello_array = hello.toCharArray();
        // copy to wrapper array
        Character[] hello_array1 = new Character[hello_array.length];
        for (int i = 0; i < hello_array.length; i++) {
           hello_array1[i] = hello_array[i];
        }
        // sort the wrapper array instead of primitives
        Arrays.sort(hello_array1, Collections.reverseOrder());                            
    }
}