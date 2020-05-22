protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);  
  buttonXMas=findViewById(R.id.button1);
  buttonXMas.setEnabled(false);
  SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
  Date xmas= dateFormat.parse("25/12/2016");
  Date today = new Date();
  if(xmas.after(today)){
    buttonXMas.setEnabled(true);
  }
  buttonXMas.setOnClickListener(new View.OnClickListener() {
         public void onClick(View v) {
             // Perform action on click
         }
     });
}