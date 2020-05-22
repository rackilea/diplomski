DBAdapter db = DBAdapter.getDBAdapter(getApplicationContext());
    if (!db.checkDatabase()) 
    {
        db.createDatabase(getApplicationContext());
    }
    db.openDatabase();
     q = db.getQuestions();