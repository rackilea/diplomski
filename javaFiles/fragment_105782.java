DBObject lookupOperation = (DBObject)new BasicDBObject(
    "$lookup", new BasicDBObject("from", "places")
        .append("localField", "address.location.place._id")
        .append("foreignField", "_id")
        .append("as", "address.location.place")       
);