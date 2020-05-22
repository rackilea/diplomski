final ListView lv = (ListView) findViewById(R.id.listView);
    query.findInBackground(new FindCallback<ParseObject>() {
        @Override
        public void done(List<ParseObject> objects, ParseException e) {
            if (e == null) {
                ArrayList<String> teachers = new ArrayList<String>();
                for (ParseObject object : objects) {
                    String name = String.valueOf(object.get("name"));
                    Log.i("teacherName", name);
                    teachers.add(name);
                }
                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, teachers);
                lv.setAdapter(arrayAdapter);
            } else {
                Log.i("Get data from parse", "There was an error getting data!");
                e.printStackTrace();
            }
        }
    });