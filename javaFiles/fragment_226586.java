@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);    

     editText1 = (EditText)findViewById(R.id.editText1); 
     editText2 = (EditText)findViewById(R.id.editText2); 
     editText3 = (EditText)findViewById(R.id.editText3); 

     button1 = (Button)findViewById(R.id.button1);  

     button1.setOnClickListener(new View.OnClickListener() {
         public void onClick(View v) {
    gtext = editText1.getText().toString();
     vgtext = editText2.getText().toString();
     mvgtext = editText3.getText().toString();

     gpoäng = Double.parseDouble(gtext);
     vgpoäng = Double.parseDouble(vgtext);
     mvgpoäng = Double.parseDouble(mvgtext);

     gvärde = gpoäng*10;
     vgvärde = vgpoäng*15;
     mvgvärde = mvgpoäng*20;

     allapoäng = (gpoäng + vgpoäng + mvgpoäng);
     allavärde = (gvärde + vgvärde + mvgvärde);

     snittbetyg = (allavärde / allapoäng);
     str = "Ditt snitt är " + snittbetyg;
             Toast.makeText(getBaseContext(), str,
                     Toast.LENGTH_SHORT).show();
         }
    });
    }