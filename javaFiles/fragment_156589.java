Collection<String> list = new ArrayList(Arrays.asList("a","b", "c", "d", "e", "f", "g"));

    List<String> sourceList = new ArrayList<String>(list);
    List<String> destinationList = new ArrayList<String>(list);

    list.add("boo");
    list.remove("b");

    sourceList.removeAll( list );
    list.removeAll( destinationList );


    System.out.println( sourceList );
    System.out.println( list );