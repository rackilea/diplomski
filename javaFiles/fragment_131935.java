Collection<Integer> id = Arrays.asList(2316, 2317, 2318);
     Collection<Integer> existingId = Arrays.asList(1004, 1762, 1892, 1342, 1942, 2316);

    Collection<Integer> similar = new HashSet<Integer>( id );
    similar.removeAll( existingId );
    System.out.println("Different:"+similar);
    System.out.println("#of items that are differnt:"+similar.size());