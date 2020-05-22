BasicDBObject query = new BasicDBObject();
        query.put("date", date);
        query.put("car",car);

        String fields = "Session";

        array.put(coll.distinct(fields, query));