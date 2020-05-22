Multimap<Key, Map<Key, Value>> mapsContainingKey = ... ;//could be a Guava Multimap
//O(n * m) complexity
for(Map<Key, Value> m : largeSetOfTreeMaps ) {
  for(Key k : m.keySet() ) {
    mapsContainingKey.put( k, m );
  }
}

//O(m)
for( Entry<Key, Map<Key, Value>> entry : mapsContainingKey.entries() ) {
  Key key = entry.getKey();
  Collection<Map<Key, Value>> mapsWithSameKey = entry.getValue();
  if( mapsWithSameKey.size() > 1 ) {
    //all maps in that collection share this key
  }
}