Document query = new Document(
    "$or", Arrays.asList(
        // First document in $or
        new Document(
            "fetchStatus", 
            new Document( "$gte", FetchStatus.PROCESSED_NLP.getID() )
            .append("$lte", fetchStatusParam)
        )
        .append("episodeID", new Document( "$in", episodeIDs)),
        // Second document in $or
        new Document("fetchStatus", PROCESSED_FETCH.getID())
        .append("isFullTextRet", false)
    )
);