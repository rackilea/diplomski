Path path = Paths.get( "/Users/basil/lat-lon.txt" );  // Path for Mac OS X.
try {
    List<GeoReading> list = new ArrayList<>();
    Stream<String> lines = Files.lines( path );
    lines.forEach( line -> list.add( new GeoReading( line ) ) );
    // Take those 14 lines and multiply to simulate large text file. 14 * 3,000 = 42,000.
    int count = 3000;
    List<GeoReading> bigList = new ArrayList<>( list.size() * count ); // Initialze capacite to expected number of elements.
    for ( int i = 0 ; i < count ; i++ ) {
        bigList.addAll( list );
    }
    long start = System.nanoTime();
    Collections.sort( bigList , new GeoReadingAscendingComparator() );
    long elapsed = ( System.nanoTime() - start );
    System.out.println( "Done sorting the GeoReading list. Sorting " + bigList.size() + " took: " + TimeUnit.MILLISECONDS.convert( elapsed , TimeUnit.NANOSECONDS ) + " ms ( " + elapsed + " nanos )." );

    System.out.println( "Dump…" );
    for ( GeoReading g : bigList ) {
        System.out.println( g );
    }
} catch ( IOException ex ) {
    System.out.println( "ERROR - ex: " + ex );
}