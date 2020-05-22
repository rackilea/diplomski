DBObject result = table.findOne(searchQuery);

 BasicDBList number = (BasicDBList)result.get("duration_value");
 BasicDBList timestamp = (BasicDBList)result.get("timestamp");

 int integer = ((Number)number.get(i)).intValue();
 Date date = (Date) timestamp.get(i);