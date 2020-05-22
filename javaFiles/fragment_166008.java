int max = Integer.MIN_VALUE;
    final List< Entry< Integer, Integer > > maxList =
            new ArrayList< Entry< Integer, Integer > >();

    for ( final Entry< Integer, Integer > entry : ht.entrySet() ) {
        if ( max < entry.getValue() ) { 
            max = entry.getValue();
            maxList.clear();
        }
        if ( max == entry.getValue() )
            maxList.add( entry );
    }