DBCollection table = db.getCollection("Students"); //my Collection
BasicDBObject courseNameDBObject = new BasicDBObject("course.course_name", "Java EE") ;
DBCursor cursor = table.find(courseNameDBObject);
while(cursor.hasNext()){
    System.out.println(cursor.next());
}