@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my_animals);

    DatabaseService databaseService = new DatabaseService();
    databaseService.readItemsFromDatabase(new DatabaseService.FirebaseCallback() {
            @Override
            public void onCallback(List<Animal> list) {
                Log.d("DATABASE_TAG", list.toString());

            }
        });
...