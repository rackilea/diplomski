DBObject query = new BasicDBObject();
   query.put("_id", project.getId());   
   DBObject projectMongoObject = new BasicDBObject();
   projectMongoObject.put("$set", new BasicDBObject("project_name",
                                                     project.getProjectName()));
   projectMongoObject.put("$pullAll", 
                          new BasicDBObject("employee_id", new int[]{3,5}));
   collectionProject.update(query, projectMongoObject);
   projectMongoObject = new BasicDBObject();
   projectMongoObject.put("$push", 
                            new BasicDBObject("employee_id",
                                              new BasicDBObject("$each",
                                                            new int[]{13,6,8})));
   collectionProject.update(query, projectMongoObject);