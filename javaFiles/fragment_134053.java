List<String> strings = Arrays.asList( "1","2","3" ) ;

// Create our mapping Iterator
Iterator<Integer> iter = new Collector<>( strings, new Mapper<String,Integer>() {
    @Override
    public Integer apply( String v ) {
        return Integer.parseInt( v ) * 2 ;
    }
} ) ;

// Collect back from iterator into a List
List<Integer> numbers = new ArrayList<>() ;
while( iter.hasNext() ) {
    numbers.add( iter.next() ) ;
}