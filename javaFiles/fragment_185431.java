protected void onStart()
    {
    super.onStart();

final Dialog dialog = new Dialog(this);
dialog.setContentView(R.layout.main);
dialog.setTitle("About Service One");


Button button = (Button) dialog.findViewById(R.id.button12);
button.setOnClickListener(new OnClickListener() {  
    @Override  
    public void onClick(View view) {  
        dialog.dismiss();            
    }  
});
TextView showMore= (TextView ) dialog.findViewById(R.id.tvShowMore);
showMore.setOnClickListener(new OnClickListener() {  
    @Override  
    public void onClick(View view) {  
Intent intent=new Intent(getApplicationContext(),ShowMoreActivity.class);
startActivity(intent);       
         }  
    });
dialog.show();

 }


And add in xml showmore TextView Which set text from string.xml 
i.e  <string name="show_more"><u>Show More </u></string> use this for set linkable text