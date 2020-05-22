ForecastEntries_Coll = db.getCollection('ForecastEntries');

ID = '553e24c1a46da1d1498b4567';

query = BasicDBObject('forecast', ObjectId(ID));

fcstResources = ForecastEntries_Coll.find(query);