List<String> userIds = new ArrayList<>();
    ParseQuery<ParseUser> userParseQuery = ParseUser.getQuery();
    userParseQuery.whereContainedIn("objectId", userIds);
    userParseQuery.findInBackground(new FindCallback<ParseUser>() {
        @Override
        public void done(List<ParseUser> objects, ParseException e) {
            if (e == null){
                //  
            } else {
                // 
            }
        }
    });