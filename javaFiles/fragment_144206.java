ParseQuery<ParseObject> query = ParseQuery.getQuery("YourClassName");
query.whereEqualTo("ID", "someID");
query.getFirstInBackground(new GetCallback<ParseObject>() {
  public void done(ParseObject object, ParseException e) {
    if (object == null) {
      Log.d("score", "The getFirst request failed.");
    } else {
      Log.d("score", "Retrieved the object.");
    }
  }
});