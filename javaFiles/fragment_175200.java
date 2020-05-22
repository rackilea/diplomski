@Override 
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_menu);

    Typeface Dotum = Typeface.createFromAsset(getAssets(),"fonts/gulim.ttc");
    TextView myTextView = (TextView)findViewById(R.id.jingenMenu1);
    myTextView.setTypeface(Dotum);

    String[] array = yourFunctionThatReturnsArray();

    spinner=(Spinner) findViewById(R.id.pkmnSel1);
    ArrayAdapter adapter = ArrayAdapter.createFromResource(this,array    , android.R.layout.simple_spinner_item); //I know it's missing the source but, that's where I'm
    spinner.setAdapter(adapter);                                                                             //lost because I can't figure out how to populate it with my array.
} 

public String[] yourFunctionThatReturnsArray(){
       String[] array = new String[SIZE];
       // put anything in array
       return array;
}