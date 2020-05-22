@Override
 protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.main2activity);

((Button) findViewById(R.id.weiter)).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        EditText et1 = (EditText) findViewById(R.id.editText2);
        String Link1 = et1.getText().toString();

        EditText et = (EditText) findViewById(editText1);
        String Kat1 = et.getText().toString();


        if (Link1.matches("") || Kat1.matches("")){
            et.setHintTextColor(RED);
            et1.setHintTextColor(RED);
        }
        else {
      Intent intent = new Intent(MainActivity2.this, MainActivity8.class);
        intent.putExtra("Kate1", Kat1);
            startActivity(intent );
        }


    }
});