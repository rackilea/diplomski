private MongoCursor<PersonDBO> ReadFewProfilesFromDB(final String objectIdAfterWhichToSearchFrom, final Integer FIND_LIMIT) {

    MongoCursor<PersonDBO> aBatchOfProfiles = null;

    try {
        if (objectIdAfterWhichToSearchFrom.equals(START_OBJECTID_OF_MONGO_BATCHES)) {
            aBatchOfProfiles = personProfile.find().limit(FIND_LIMIT).as(PersonDBO.class);
        } else {
            aBatchOfProfiles = personProfile.find("{_id: {$gt: #}}", new ObjectId(objectIdAfterWhichToSearchFrom)).limit(FIND_LIMIT).as(PersonDBO.class);
        }
    } catch(Exception e) {logger.error("Problem while trying to find {} personProfiles, starting from objectID {}. {}, {}", FIND_LIMIT, objectIdAfterWhichToSearchFrom, e.getMessage(), e.getCause());}

    if (aBatchOfProfiles == null) {
        logger.error("profiles collection is null. Nothing more to iterate OR there was an exception when finding profiles. If exception, there would be an error printed above.");
        return null;
    }         

    return aBatchOfProfiles;
}