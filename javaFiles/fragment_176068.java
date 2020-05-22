Session session = getSession();      
  Database db = session.getCurrentDatabase();

  Document profile = db.getProfileDocument("solrIndexer","nameOfTheDatabase");
  Item lastTimeIndexedItem = profile.getFirstItem("lastTimeYouIndexed");
  DateTime lastTimeIndexed = lastTimeIndexedItem.getDateTimeValue();

  DocumentCollection col = db.search("Select @All", lastTimeIndexed);

  // (Your code goes here)