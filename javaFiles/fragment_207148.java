// getSubjects() will now return a List of SubjectProviders
// as you can see below
public ArrayList<SubjectProvider> getSubjects(){ 
    // obtain the database
    SQLiteDatabase db = this.getReadableDatabase();
    // create the query that should return name results and hours
    // for each subject that has the subuser_id equal to the user_id
    String selectQuery = "SELECT " + subject.SUBJECT_NAME +
                        ", " + subject.SUBJECT_RESULTS +
                        ", " + subject.SUBJECT_HOURS +
                        " FROM " + subject.TABLE_SUBJECT +
                        " WHERE " + subject.SUBUSER_ID +
                        " = " + subject.USER_ID;

    // create the arraylist in which we will late store all the subjectproviders
    // this arraylist will be returned so you can use it in your subjects class
    ArrayList<SubjectProvider> subjectList = new  ArrayList<SubjectProvider>()
    // execute the select-query
    Cursor c = db.rawQuery(selectQuery, null);
    // if the cursor is not empty aka some at least one row was found
    if (c.moveToFirst()) {
        // loop through all the results
        do {
            System.out.println("Results were found!");
            // get the values from the cursor
            String sub_name, sub_results, sub_hours;
            sub_name = cursor.getString(0);
            sub_results = cursor.getString(1);
            sub_hours = cursor.getString(2);

            // create a new subjectprovider Object to store the values in it
            SubjectProvider subjectProvider = new SubjectProvider(sub_name, sub_results, sub_hours);

            System.out.println("Subject: "+sub_name+" got" +sub_results+" in "+sub_hours);
            // add it to the arraylist
            subjectList.add(subjectProvider);
        // stop if there are no more results
        } while (c.moveToNext());
    }
    // return the list to your subjects class
    return subjectList;
}