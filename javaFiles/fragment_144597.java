Foo getItem(Iterator<Foo> it) {
    Map<Integer, Foo> categoryToFoo = new HashMap<Integer, Foo>();
    Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
    int maxCount = 0;
    while(it.hasNext()) {
        Foo foo = it.next();
        int category = foo.getCategory();
        int categoryCount = 1;
        if ( ! categoryToFoo.contains( category ) ) {
            categoryToFoo.put( category, foo );
        }
        else {
            categoryCount = counts.get( category ) + 1;
        }
        counts.put( category, categoryCount );
        if ( categoryCount > maxCount ) {
            maxCount = categoryCount;
        }
    }

    List<Foo> possible = new ArrayList<Foo>()
    for ( Map.Entry entry : counts.entrySet() ) {
        if ( entry.getValue() == maxCount ) {
            possible.add( categoryToFoo.get( entry.getKey() ) );
        }
    }

    return possible.get( new Random().nextInt( possible.size() ) );
}