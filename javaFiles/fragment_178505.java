Map<String,Thing> map = new TreeMap<String,Thing>(new Comparator<Thing>(){
     public int compare( Thing one, Thing two ) {
         int result = one.y - two.y;
         if( result == 0 ) { // same y coordinate use another criteria
             result = one.x - two.x;
             if( result == 0 ) { //still the same? Try another criteria ( maybe creation time
                 return one.creationTime - two.creationTime
             }
          }
          return result;
     }
});