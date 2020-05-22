BasicDBList andList = new BasicDBList();
andList.add(new BasicDBObject("by", "tutorials point"));
andList.add(new BasicDBObject("title", "MongoDB Overview")); 
BasicDBObject and = new BasicDBObject("$and", andList);
BasicDBObject command = new BasicDBObject("find", "collectionName");
command.append("filter", and); 
mongoTemplate.executeCommand(command);