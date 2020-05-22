public String getFilename(String key) {
    DBCursor cur = audit.find(new BasicDBObject().append("auditorComments.filepath", "NewAudit6269242818132644222/withoutJS.txt"));
    String test = null;
    while (cur.hasNext()) {
        BasicDBObject current_object = (BasicDBObject) cur.next();

        BasicDBList auditorComments = (BasicDBList) current_object.get("auditorComments");
        test = ((BasicDBObject) auditorComments.get(0)).getString("filename");
        System.out.println(test);
    }
    return test;
}