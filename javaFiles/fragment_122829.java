this.trackedEpisodesReg.entrySet().stream()
    .filter(ep -> ep.getValue().isExpired())
    .forEach(ep -> {

        BasicDBObject updateFields = new BasicDBObject();
        updateFields.append("isExpired", true);

        BasicDBObject setQuery = new BasicDBObject();
        setQuery.append("$set", updateFields);

        BasicDBObject searchQuery = new BasicDBObject("_id", new ObjectId(ep.getValue().getEpisodeID()));

        dbCollection.updateOne(searchQuery, setQuery);
    });