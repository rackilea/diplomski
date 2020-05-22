@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button B1 =  findViewById(R.id.button1);
    EditText et_tusd = findViewById(R.id.tusd);

    B1.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            String textFromInput_tusd = et_tusd.getText().toString();

            Intent i=new Intent(MainActivity.this,Main2Activity.class);
            i.putExtra("i1",textFromInput_tusd);
            startActivity(i);
        }
    });
}