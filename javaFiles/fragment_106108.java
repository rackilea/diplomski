EditText nameInput; // define your edit text

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.content_inventory);

    nameInput = (EditText) findViewById(R.id.edit_name); // initialize your edit text
.
.
.

nameInput.getText().toString() // get data inside your edit text