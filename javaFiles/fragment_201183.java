protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_food);

    //getting the reference of artists node
    databaseFoods = FirebaseDatabase.getInstance().getReference("foods").child(uid);

    ...
}