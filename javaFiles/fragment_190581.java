@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.passw_layout);

    initWheel(R.id.passw_1, new String[] { "You", "Me", "Us" });
    initWheel(R.id.passw_2, new String[] { "Are", "Going", "Went" });
    initWheel(R.id.passw_3, new String[] { "There", "Here", "Away" });

    Button mix = (Button) findViewById(R.id.btn_mix);
    mix.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
            mixWheel(R.id.passw_1);
            mixWheel(R.id.passw_2);
            mixWheel(R.id.passw_3); 

        }
    });

    Button share = (Button) findViewById(R.id.btn_share);
    share.setOnClickListener(new OnClickListener() {   
        public void onClick(View v) {
           // call some other methods before that I guess...

           String values = getAllWheelValues();
           startActivity(createEmailIntent(values)); 
    }
    });

}

    private Intent createEmailIntent(String values) { 

           Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
           emailIntent.setType("text/plain");
           emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, getResources().getString(R.string.Subject));
           emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, values);

           return emailIntent;
    }