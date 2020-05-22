public static void printMap(Map mp) {
    for(Map.Entry pairs : mp.entrySet()) {
        if(pairs.getValue() >= 4)
        {
          System.out.println(pairs.getKey());
        }
    }
}