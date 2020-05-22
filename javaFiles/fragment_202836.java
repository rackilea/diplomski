import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        List<Integer> list1 = Arrays.asList(new Integer[] { 1, 1, 1, 2, 4, 4 });
        List<Integer> list2 = Arrays.asList(new Integer[] { 1, 2, 2, 3 });
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
        for (Integer i : list1) {
            if (hashMap1.containsKey(i)) {
                hashMap1.put(i, hashMap1.get(i) + 1);
            } else {
                hashMap1.put(i, 1);
            }
        }
        for (Integer i : list2) {
            if (hashMap2.containsKey(i)) {
                hashMap2.put(i, hashMap2.get(i) + 1);
            } else {
                hashMap2.put(i, 1);
            }
        }
        HashSet<Integer> dedup = new HashSet<>();
        for (Integer i : list1) {
            dedup.add(i);
        }
        for (Integer i : list2) {
            dedup.add(i);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer i : dedup) {
            Integer n1 = hashMap1.get(i);
            Integer n2 = hashMap2.get(i);
            int n = Math.abs((n1 == null ? 0 : n1) - (n2 == null ? 0 : n2));
            for (int j = 0; j < n; ++j) {
                result.add(i);
            }
        }
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}