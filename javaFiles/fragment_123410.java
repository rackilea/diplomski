EditText Cnic;
int maxLength = 15;
String str;
Button save;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

 Cnic = (EditText)findViewById(R.id.cnic_edtext);
 save = (Button)findViewById(R.id.save_btn);
    Cnic.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
    Cnic.setKeyListener(new DigitsKeyListener().getInstance("0123456789-"));


    Cnic.addTextChangedListener(new AutoAddTextWatcher(Cnic,
            "-",
            5, 12));


    save.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
             str =  Cnic.getText().toString();

            Toast.makeText(MainActivity.this, "Cnic "+str, Toast.LENGTH_SHORT).show();

        }
    });



}