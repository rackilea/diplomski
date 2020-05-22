double lat_lng_values[] = {144.6682361, -37.8978304};
    BasicDBObject geo = new BasicDBObject("$geometry", new BasicDBObject("type","Point").append("coordinates",lat_lng_values));
    BasicDBObject filter = new BasicDBObject("$near", geo);
    filter.put("$maxDistance", 3000);
    BasicDBObject locQuery = new BasicDBObject("location", filter);
    System.out.println(locQuery);