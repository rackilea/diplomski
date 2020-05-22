// create a new arraylist, that will contain the values from your
    // getsubjects method

     ArrayList<SubjectProvider> my_array_list = (ArrayList<SubjectProvider>) databaseHelper.getSubjects();
    // create an adapter so you can add the values from the arraylist to your listview
    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
             subjects.this, 
             android.R.layout.simple_list_item_1,
             my_array_list);

     // set the previously created adapter as an adapter for your listview
     lvSubjects.setAdapter(arrayAdapter);