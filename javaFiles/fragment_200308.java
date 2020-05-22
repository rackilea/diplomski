public static void main(String[] args){
    int[] arryNum = new int[] { 4, 4, 4, 3, 4, 5, 4, 3, 4, 4, 4, 5, 4, 5, 5, 5, 4, 3, 2, 15, 4,
            3, 4, 6, 4, 3, 4, 5, 4, 2, 4, 5, 4, 3, 2, 5, 4, 3, 5, 4, 0, 4, 3, 4, 5, 4, 3, 0, 4,
            5, 4, 3, 5, 4, 2, 3, 2, 3, 4 };
    Map<Integer, Integer> lookup = new HashMap<>();
    for (int key : arryNum) {
        if(lookup.containsKey(key)) {
            lookup.put(key, lookup.get(key) + 1);
        } else {
            lookup.put(key, 1);
        }
    }

    for (Integer keys : lookup.keySet()) {
        System.out.println(keys + " Found " + lookup.get(keys) + " Times");
    }

}