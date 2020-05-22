FindOneAndUpdateOptions options = new FindOneAndUpdateOptions();
options.returnDocument(ReturnDocument.AFTER);
options.upsert(true);


Bson query = Filters.eq("event", "sold my iPhone");
Bson update =  Updates.currentDate("lastModified");
collection.findOneAndUpdate(query, update, options);