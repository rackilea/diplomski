//Initial RangeMap  
final RangeMap<java.sql.Timestamp, String> cache = TreeRangeMap.create();
...
String value = cache.get(thisTimestamp);
if(value == null){
     String queryFromDB = ...;//Query from DB
     cache.put(Range.atMost(thisTimestamp), queryFromDB);
     value = queryFromDB;
}