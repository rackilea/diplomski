/**
 * Replace a document in the collection according to the specified arguments.
 *
 * @param filter      the query filter to apply the the replace operation
 * @param replacement the replacement document
 * @return the result of the replace one operation
 * @throws com.mongodb.MongoWriteException        if the write failed due some other failure specific to the replace command
 * @throws com.mongodb.MongoWriteConcernException if the write failed due being unable to fulfil the write concern
 * @throws com.mongodb.MongoException             if the write failed due some other failure
 * @mongodb.driver.manual tutorial/modify-documents/#replace-the-document Replace
 */
UpdateResult replaceOne(Bson filter, TDocument replacement);