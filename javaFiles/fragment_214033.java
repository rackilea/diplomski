List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
BasicDBObject dbo = new BasicDBObject();
dbo.append("transport", "plane");
DBCursor cur = collection.find(dbo);
while (cur.hasNext()) {
            list.add(JSONHelper.toJSON(cur.next().toMap()));
        }