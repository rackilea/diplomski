DatabaseAccessClass databaseAccess;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_activity_name);
    databaseAccess = DatabaseAccessClass.getInstance(this);
    ...
}