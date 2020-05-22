BasicDBObject where =
    new BasicDBObject()
        .put("INSTITUTION_ID", instid);
        .put("RuleID", ruleid);

BasicDBObject update =
    new BasicDBObject("$pull",
        new BasicDBObject("Matrix",
            new BasicDBObject("Key",
                new BasicDBObject("$regex",
                    java.util.regex.Pattern.compile(json.getString("Code") + "$")))));

collection.update(where, update);