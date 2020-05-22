ParseQuery<ParseObject> query = ParseQuery.getQuery(“GameScore");
    query.fromLocalDatastore();
    query.getInBackground("xWMyZ4YE", new GetCallback<ParseObject>() {
    public void done(ParseObject object, ParseException e) {
       if (e == null) {
    // object will be your game score
       } else {
    // something went wrong
    }
  }
});