ParseQuery<ParseObject> query = ParseQuery.getQuery(“GameScore");
    query.getInBackground("xWMyZ4YE", new GetCallback<ParseObject>() {
    public void done(ParseObject object, ParseException e) {
       if (e == null) {

    // object will be your game score so save it offline
       object.pinAllInBackground();  
       } else {
    // something went wrong
    }
  }
});