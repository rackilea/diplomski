@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        //Initializing the db
        DatabaseNew db = new DatabaseNew(this);
        //sending dummy data you can send actual workout and time like this
        db.saveData("pull up","30 mins");
        db.saveData("push up","40 mins");
        db.saveData("Leg up","30 mins");
        db.saveData("crunches","30 mins");
        db.saveData("Bench Press","30 mins");

        //to retrieve data from data base
        List<HashMap<String,String>> data = db.getData();
        for (HashMap<String,String> a : data){
            Log.e("TestActivity"," "+"Workout : "+a.get("WORKOUT")
                    +" "+"Time : "+a.get("WORKOUT_TIME"));
        }
    }