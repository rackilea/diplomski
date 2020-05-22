Set< String > filterList = Arrays.asList( "z", "b" ).stream( ).collect( Collectors.toSet( ) );
List< String > toCheckList = Arrays.asList( "z", "b", "a", "q", "w" );
boolean contains = toCheckList.stream( ).anyMatch( list -> filterList.contains( list ) );

    if ( contains ) {
        System.out.println( "Contains" );

        //your logic
    }