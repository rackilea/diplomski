DBObject queryObject = new BasicDBObject("id", 5);
DBCollection collection = ds.getCollection(MyTable.class);

MapReduceCommand mrc = new MapReduceCommand(collection, // collection to do map-reduce on
                                            map, // map function
                                            reduce, // reduce function
                                            null, // output collection for the result
                                            MapReduceCommand.OutputType.INLINE, // output result type
                                            queryObject); // query to use in map reduce function