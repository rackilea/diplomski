try {
  Long startDate = 20171114L;
  Long endDate = 20171116L;
  BasicDBObject data = new BasicDBObject();
  data.put("Date", new BasicDBObject( new BasicDBObject( "$gte", startDate).append("$lte", endDate)));
} catch(ParseException e){
  e.printStackTrace
}