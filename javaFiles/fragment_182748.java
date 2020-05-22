public class runGraphics extends Activity {
    ImageButton polarCap1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.your_layout.xml);//You need this code line.

        polarCap1 = (ImageButton) findViewById(R.id.polarCapButton);
        polarCap1.setOnClickListener(new OnClickListener() {
               @Override
               public void onClick(View v) {
                        Toast.makeText(runGraphics.this, "IT WORKED",
                        Toast.LENGTH_LONG).show();
               }//end onClick function         
        });//end setOnClickListener


    }//end onCreate function
}//end runGraphics class