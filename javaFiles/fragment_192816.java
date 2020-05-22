Map<String,String> myMapTmp = XXDao().getXXX();
// TreeMap keeps all entries in sorted order
TreeMap<String, String> sortedMap = new TreeMap<>(myMapTmp);
Set<Entry<String, String>> mappings = sortedMap.entrySet(); 
System.out.println("HashMap after sorting by keys in ascending order "); 
for(Entry<String, String> mapping : mappings){ 
   System.out.println(mapping.getKey() + " ==> " + mapping.getValue()); 
}