protected Void doInBackground(Void... params) {
        // Gets the current list of todos in sorted order
        ParseQuery query = new ParseQuery("TestObject");
        query.orderByDescending("_created_at");

        try {
            todos = query.find();
        } catch (ParseException e) {

        }

        runOnUiThread(new Runnable() {
               public void run() {
                  setVisibility();
               }});

        return null; // RETURN STATEMENT HERE
    }