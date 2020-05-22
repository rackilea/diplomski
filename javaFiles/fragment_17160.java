Mongo mongo = new Mongo('your paramaters');
    DB db = mongo.getDB("yourdb");

    DBCollection collection = db.getCollection("dummyColl");
    String json = "{
        'type': 'Feature',
        'geometry': {
          'type': 'Point',
          'coordinates': [125.6, 10.1]
        },
       'properties': {
          'name': 'Dinagat Islands'
       }
   }";

    DBObject dbObject = (DBObject)JSON.parse(json);

    collection.insert(dbObject);