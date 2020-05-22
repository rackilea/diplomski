@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main3);
    Spinner spinner = (Spinner) findViewById(R.id.spinner);
    Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() 
     {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                       if (spinner.getSelectedItem().toString().equals("Selection 1"))

                       {
                          textView8.setText("3");
                       }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

  spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() 
     {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                       if (spinner2.getSelectedItem().toString().equals("Option 2"))
                       {
                          textView8.setText("3");
                       }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });             

     }