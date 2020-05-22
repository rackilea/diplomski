List<Integer> x = new ArrayList<Integer>(Arrays.asList( {-5,-7,10,2} } );
for( int i = 0; i < x.size(); i++ ){
   x.set( i, Math.abs(x.get(i)) );
}

return Collections.max( x );