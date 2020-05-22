private Button start;
private EditText nameField;

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    start = (Button) findViewById(R.id.start);
    nameField = (EditText) findViewById(R.id.nameField);

    start.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            String name = nameField.getText().toString();

        }
    });
}