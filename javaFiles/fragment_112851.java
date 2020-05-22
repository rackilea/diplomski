BasicDBObject criteria = new BasicDBObject();
criteria.append("color", "black");
criteria.append("shape", "round");
criteria.append("weight", 100);

DBCursor cur = widgets.find(criteria);