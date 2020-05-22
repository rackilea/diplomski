import java.util.HashMap;
import java.util.Map;

public class OverrideHashCode {

    public void mutableObjectKeys() {
        Map<MyNumber, String> map = new HashMap<>();
        MyNumber num1 = new MyNumber(2500);
        map.put(num1, "Shreya");

        System.out.println(map);
        System.out.println(num1);

       //This line was your issue. You placed the MyNyumber in the map
        //The hashcode pulls the number value from MyNumber to hash the entry (2500 )
        //Then you change the value of number
        //num1.getNumber() = 100;
        System.out.println(map);
        System.out.println(num1);

        //This was hashed at 2500, but you changed the MyNumber to 100 - no match
        System.out.println(map.get(num1)); // prints null - not anymore

        //Let's put a second object in the Map
        map.put(new MyNumber(500), "GroovyIsBetter!");

        //When you work with Maps, you are commonly trying to get values out of the map based on the key.
        //In this example, our key's are MyNumber(s)
        //We have made MyNumber.number immutable (which is good).
        //Because you implemented your own hashcode and equals, you can even pull the value out of the map
       //with a new MyNumber object that has the same number value as the original key you placed in the map
        System.out.println("\n" + map.get(new MyNumber(2500)));
        System.out.println(map.get(new MyNumber(500)));

        //Now we can remove one of the keys and recheck
        //Should come up null
        map.remove(new MyNumber(500));
        System.out.println(map.get(new MyNumber(500)));
    }

    public static void main(String... args){
        new OverrideHashCode().mutableObjectKeys();;
    }