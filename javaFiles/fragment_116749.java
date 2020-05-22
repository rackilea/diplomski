import java.util.*;
import java.lang.reflect.*;

class HashTest {        

    /** Results:
     C:\Documents and Settings\glowcoder\My Documents>java HashTest
        Orig hash: -804322678
        New value: STACKOVERFLOW
        Contains orig: true
        Contains copy: false
     */

    public static void main(String[] args) throws Exception {

        Set<String> set = new HashSet<String>();
        String str = "StackOverflow";
        System.out.println("Orig hash: " + str.hashCode());
        set.add(str);

        Field stringValue = String.class.getDeclaredField("value");
        stringValue.setAccessible(true);
        stringValue.set(str, str.toUpperCase().toCharArray()); // 

        System.out.println("New value: " + str);

        String copy = new String(str); // force a copy
        System.out.println("Contains orig: " + set.contains(str));
        System.out.println("Contains copy: " + set.contains(copy));
    }

}