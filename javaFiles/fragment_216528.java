ParseQuery<ParseUser> userQuery = ParseUser.getQuery();
userQuery.findInBackground(new FindCallback<ParseUser>() {
    public void done(List<ParseUser> parseUsers, ParseException e) {
        if (e == null) {
            Log.d("users", "Retrieved " + parseUsers.size());
            ParseUser[] data = parseUsers.toArray(new ParseUser[parseUsers.size()]);
            String[] strings = new String[data.length];
            for (int i = 0; i < data.length; i++) {
                strings[i] = data[i].getString(ParseConstants.KEY_USERNAME);
            }
            // Test to see if it was correctly printing out the array I wanted.
            // System.out.println(Arrays.toString(strings));
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, strings);
            AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.searchUserTextField);
            if(parseUsers.size() < 40) textView.setThreshold(1);
            else textView.setThreshold(2);
            textView.setAdapter(adapter);
        } else {
            Log.d("users", "Error: " + e.getMessage());
        }
    }
});