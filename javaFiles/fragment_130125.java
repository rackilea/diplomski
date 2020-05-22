public static void put(Map<Integer, Integer[]> map, Integer k, Integer... v) {
    map.put(k, v);
}

...

put(map, 1, 1,2,3,4);