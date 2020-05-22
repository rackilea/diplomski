AtomicInteger counter = map.get( p.getName() );
if( null == counter ) {
   counter = new AtomicInteger();
   map.put( p.getName(), counter );
}

counter.increment();