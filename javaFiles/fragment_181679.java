import java.util.Map;
import java.util.TreeMap;

public class MapToStringExample {
    public static void main(String[] args) {
        Map<String,String> map1 = new TreeMap<>();
        map1.put( "key1", "value1, key2=value2" );
        System.out.println( "Map1: "+map1 );

        Map<String,String> map2 = new TreeMap<>();
        map2.put( "key1", "value1" );
        map2.put( "key2", "value2" );
        System.out.println( "Map2: "+map2 );
    }
}