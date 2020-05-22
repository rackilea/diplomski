DBObject dbObject = (DBObject) JSON.parse(dataJson);

// TODO: Convert dbObject's initialDate property back to date type here

DBCollection table = mongoDB.getCollection(data
        .getModel().getProjectName());