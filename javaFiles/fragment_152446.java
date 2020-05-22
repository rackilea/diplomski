BasicDBObject query = new BasicDBObject();
query.put("_id", new ObjectId("52a6a2cc05e1c80fd5e9295c"));
DBObject dbo = blogTable.findOne(query);
if ( dbo != null ) {
    System.out.println( "got u " + dbo );
} else {
    System.out.println( "not found" );
}