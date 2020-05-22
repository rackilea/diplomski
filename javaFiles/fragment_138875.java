ArrayList<ArrayList<Integer>> test2 = new ArrayList<ArrayList<Integer>>();
addToSize( test2, 
    new Factory<ArrayList<Integer>>() {
       public ArrayList<Integer> create() { 
           return new ArrayList<Integer>( );
       }
    }, 10 ); // compiles