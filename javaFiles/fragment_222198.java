import java.util.*;

public class A {
    public static void main(String[] args) {
        Map<Integer, ArrayList<Character>> map1 = new HashMap<>(); // Map containing few Characters under one key
        map1.put(1, new ArrayList<Character>()); 
        map1.get(1).add('a');
        map1.get(1).add('b');
        map1.put(2, new ArrayList<Character>());
        map1.get(2).add('c');
        System.out.println("map1: " + map1); // prints: map1: {1=[a, b], 2=[c]}
        Map<Integer, ArrayList<HashMap<Integer, Character>>> map2 = new HashMap<>(); // Map storing as keys 5 and 6, values are maps from map1
        map2.put(5, new ArrayList<HashMap<Integer, Character>>());
        map2.put(6, new ArrayList<HashMap<Integer, Character>>());
        for(Map.Entry<Integer, ArrayList<Character>> entry : map1.entrySet()) { // For each Integer-ArrayList pair from map1...
            if(entry.getKey().equals(1)) { // Check if key Integer is equal to 1, if it is...
                for(Character character : entry.getValue()) { // Create Maps containg pairs of Integer as key and each Character as value...
                    HashMap<Integer, Character> innerMap = new HashMap<>();
                    innerMap.put(entry.getKey(), character);
                    map2.get(5).add((new HashMap<Integer,Character>(innerMap)));
                }
            }
            if(entry.getKey().equals(2)) { // Check if key Integer is equal to 1, if it is...
                for(Character character : entry.getValue()) { // Create Maps containg pairs of Integer as key and each Character as value...
                    HashMap<Integer, Character> innerMap = new HashMap<>();
                    innerMap.put(entry.getKey(), character);
                    map2.get(6).add((new HashMap<Integer,Character>(innerMap)));
                }
            }

        }
        System.out.println("map2: " + map2); // prints: map2: {5=[{1=a}, {1=b}], 6=[{2=c}]}
    }
}