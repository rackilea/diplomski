@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_log_in);
    username = (EditText)findViewById(R.id.userEditText);
    password = (EditText)findViewById(R.id.passEditText);
}