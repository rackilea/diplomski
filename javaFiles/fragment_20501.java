Map<String, Integer> map = new HashMap<>();
map.put( "a", 1 );
map.put( "b", 2 );

//you create a list that's not backed by the map here but that isn't a problem
//since the list elements, i.e. the entries, are backed by the map
List<Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
entryList.get(0).setValue( 5 );

System.out.println( map ); //prints: {a=5, b=2} (note that order is a coincidence here)