Bson query =
        // where field_num > 100
        new BasicDBObject("field_num", new BasicDBObject("$gte", 100))

        // where status is ' complete'
        .append("status", new BasicDBObject("$eq", "complete"))

        // where description does not contain 'abc' 
        // note: this uses inverse matching since the $not operator
        // is not allowed with the $regex operator
        .append("description", new BasicDBObject("$regex", "^((?!abc).)*$"));