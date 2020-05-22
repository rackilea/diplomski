//  h1={{0,1},{1,4},{2,5},{3,6}}
    Hashtable<Integer, Integer> h1 = new Hashtable<>();
    h1.put(0, 1);
    h1.put(1, 4);
    h1.put(2, 5);
    h1.put(3, 6);

//  h2={{0,1},{2,5}}
    Hashtable<Integer, Integer> h2 = new Hashtable<>();
    h2.put(0, 1);
    h2.put(2, 5);

    Set<Entry<Integer, Integer>> e1 = h1.entrySet();
    Set<Entry<Integer, Integer>> e2 = h2.entrySet();

    System.out.println(e2.containsAll(e1));  // false
    System.out.println(e1.containsAll(e2));  // true