final TreeMap<java.sql.Timestamp, String> cache = new TreeMap<>();
...
//Get least key greater than or equal to the 'thisTimestamp' 
Map.Entry<java.sql.Timestamp, String> entry = cache.ceilingEntry(thisTimestamp);
if(entry == null){
   String queryFromDB = ...;//Query from DB
   cache.put(thisTimestamp, queryFromDB);
   value = queryFromDB;
} else {
   value = entry.getValue();
}