package stackoverflow;

import java.util.*;

class Vo {}

public class MultipleRefs {
    public static void main(String[] args) {

        Map<String, List<Vo>> mapVo = new HashMap<>();
        Set<String> set = new HashSet<>();


        Map<String, Object> commonMap = new HashMap<>();

        //commonMap.put("a", Map) 
        commonMap.put("mapVoOne", mapVo);
        commonMap.put("setOne", set);

        commonMap.forEach((key, value) -> processElement(value));
    }

    public static void processElement(Object commonMapObject) {
        if (commonMapObject instanceof Map) {
            System.out.println("Got map; but types held in the map are not known due to type-erasure");

            // This is where things will get messy:
            Map<String, List<Vo>> map = (Map<String, List<Vo>>) commonMapObject;

            System.out.println("  processElement prints map: " + map);
        }

        if (commonMapObject instanceof Set) {
            System.out.println("Got set; but types held in the set are not known due to type-erasure");

            // This is where things will get messy:
            Set<String> set = (Set<String>) commonMapObject;

            System.out.println("  processElement prints set: " + set);
        }
    }
}