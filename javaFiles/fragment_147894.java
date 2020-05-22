@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    toggle = (ToggleButton) findViewById(R.id.bRedGreen);
    toggle.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            minuskugle = (Button) findViewById(R.id.bBallhole);
            if(toggle.isChecked())
               minuskugle.setBackgroundResource(R.drawable.redballinhole);
            else
               minuskugle.setBackgroundResource(R.drawable.xy);


        }

    });
}