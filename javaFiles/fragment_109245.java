Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        save  = (Button) findViewById(R.id.button1);//this line is before onclicklistener.
 save.setOnclickListner(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            name = nameXML.getText().toString(); 
            Editor nameEditor = filename.edit();
            nameEditor.putString("nameString", name);
            nameEditor.commit();
        }
    });
    }