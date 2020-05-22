import java.util.Arrays;
import java.util.Collections;

import org.apache.commons.lang.ArrayUtils;

public class MinMaxValue {

    public static void main(String[] args) {
        char[] a = {'3', '5', '1', '4', '2'};

        List b = Arrays.asList(ArrayUtils.toObject(a));

        System.out.println(Collections.min(b));
        System.out.println(Collections.max(b));
   }
}