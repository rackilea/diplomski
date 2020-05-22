BasicDBObject query = new BasicDBObject("RoomNumber", 602);
BasicDBObject projection = new BasicDBObject("RoomType", 1);
projection
.append("Reserved", 1)
.append("RegularRate", 1)
.append("_id", 0);
DBObject result = collection.findOne(query, projection);