List< String > filterList = Arrays.asList( "z" );
List< String > toCheckList = Arrays.asList( "z", "b", "a", "q", "w" );

boolean contains = toCheckList.stream( ).anyMatch( list -> filterList.stream( ).anyMatch( filter -> StringUtils.containsIgnoreCase( filter, list ) ) );

    if ( contains ) {
        System.out.println( "Contains" );
        //your logic
    }