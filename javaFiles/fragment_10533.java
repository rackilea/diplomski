DBCollection collection = db.getCollection("reads");
BasicDBObject query = new BasicDBObject();
DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
String dateInString = "2014-09-29T12:03:00Z";
Date date = df.parse(dateInString);

query.append("status.name", "Expired")
     .append("_id.eT", date)
     .append("v", 169000);