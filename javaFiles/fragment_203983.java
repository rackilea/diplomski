BasicDBList Project_Detail = new BasicDBList();
while (cursor.hasNext()) {
                    BasicDBObject object=new BasicDBObject();
                    object = (BasicDBObject) cursor.next();
                    BasicDBObject temp = new BasicDBObject();
                    temp.append("ProjectName", object.get("ProjectName"));
                    temp.append("ProjectNumber", object.get("ProjectNumber"));
                    Project_Detail.add(temp);

                }