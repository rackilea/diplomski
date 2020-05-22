/**
 * Update a single document in the collection according to the specified arguments.
 *
 * @param filter a document describing the query filter, which may not be null.
 * @param update a document describing the update, which may not be null. The update to apply must include only update operators.
 * @return the result of the update one operation
 * @throws com.mongodb.MongoWriteException        if the write failed due some other failure specific to the update command
 * @throws com.mongodb.MongoWriteConcernException if the write failed due being unable to fulfil the write concern
 * @throws com.mongodb.MongoException             if the write failed due some other failure
 * @mongodb.driver.manual tutorial/modify-documents/ Updates
 * @mongodb.driver.manual reference/operator/update/ Update Operators
 */
UpdateResult updateOne(Bson filter, Bson update);