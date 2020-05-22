@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_activity);


    Button button = (Button) findViewById(R.id.yourButtonId);
    button.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
            EditText edit = (EditText) findViewById(R.id.editText);
            edit.setText(total);
        }
    });

}