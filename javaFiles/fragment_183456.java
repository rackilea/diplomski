String user1;
String user2;

// build first AND condition
ParseQuery<ParseObject> queryPart1 = ParseQuery.getQuery("Message");
queryPart1.whereEqualTo("sender", user1);
queryPart1.whereEqualTo("receiver", user2);

// build second AND condition
ParseQuery<ParseObject> queryPart2 = ParseQuery.getQuery("Message");
queryPart2.whereEqualTo("sender", user2);
queryPart2.whereEqualTo("receiver", user1); 

// list all queries condition for next step
List<ParseQuery<ParseObject>> queries = new ArrayList<ParseQuery<ParseObject>>();
queries.add(queryPart1);
queries.add(queryPart2);

// Compose the OR clause 
ParseQuery<ParseObject> innerQuery = ParseQuery.or(queries);
innerQuery.addAscendingOrder("createdAt"); // apply sorting for creation date ascending (use addDescendingOrder for Desc sorting)

// *** Parse does not allow selection result greater than 1000 elements for query, so you may need to paging your system
//innerQuery.setSkip(10); // skip the first 10 results
//innerQuery.setLimit(200); // limit selection to first 200 elements ( from your skip offset if set, from the first otherwise )

// Run selection asynchronously 
innerQuery.findInBackground(new FindCallback<ParseObject>() {

  public void done(List<ParseObject> results, ParseException e) {
    // Do your stuff with 'results' list, if no error has been occurred
    // ...
    // ..
    // .
  }

});