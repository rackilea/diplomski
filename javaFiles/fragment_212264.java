Integer time = map.get(p);

if ( time == null ) {
     map.put( p, 0 );
} else {
     map.put( p, time+1);
}