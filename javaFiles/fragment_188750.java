NavigableMap<Integer,String> nmap =
        new TreeMap<Integer,String>();

    nmap.put(3, "Three");
    nmap.put(1, "One");
    nmap.put(4, "Four");
    nmap.put(5, "Five");
    nmap.put(7, "Seven");

    System.out.println(nmap);
    // {1=One, 3=Three, 4=Four, 5=Five, 7=Seven}

    System.out.println(nmap.firstKey()); // 1
    System.out.println(nmap.lastEntry().getValue()); // Seven
    System.out.println(nmap.higherKey(1)); // 3 
    System.out.println(nmap.lowerEntry(6).getValue()); // Five

    NavigableMap<Integer,String> sub = nmap.subMap(2, true, 5, true);
    for (Map.Entry<Integer,String> entry : sub.entrySet()) {
        System.out.printf("%s => %s%n",
            entry.getKey(),
            entry.getValue()
        );
    }
    // 3 => Three
    // 4 => Four
    // 5 => Five