import java.math.BigDecimal;
import java.util.*;
public class MyTest {
    public static void main(String[] args) {
        BigDecimal myBigDecimal = new BigDecimal(11);
        Map<Integer, String> myMap = new HashMap<Integer, String>();
        myMap.put(new Integer(11), "Hello World!");
        String message = (String) myMap.get(myBigDecimal.intValue());
        System.out.println(message);
    }
}