Integer[] ids = {3, 5, 12, 23};
ParseQuery<ParseObject> query = ParseQuery.getQuery("YourObjectName");
query.whereContainedIn("yourObjectsIdField", Arrays.asList(ids));
query.findInBackground(new FindCallback<ParseObject>() {
    void done(List<ParseObject> results, ParseException e) {
        // enter code to execute after query has finished here
    }
});