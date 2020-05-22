BasicDBObject searchQuery = new BasicDBObject();
searchQuery.put("email", email_id);
cursor = collection.find(searchQuery);

DBObject resultElement = null;
resultElement = cursor.next();

if(resultElement.containsField("username")){
     String password = (String) resultElement.get("password");
}