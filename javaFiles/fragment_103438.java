EditText hex;
Button ok;
RelativeLayout baselayout;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    hex = (EditText)findViewById(R.id.hex);
    ok = (Button)findViewById(R.id.btn);
    baseLayout=(RelativeLayout)findViewById(R.id.layout);

    ok.setOnClickListener(new OnclickListener){
        @Override
        public void onClick(View v)
           {
            String colorString=hex.getText().toString();

           //Validate Color before setting
            try {
                Color filteredColor = Color.parseColor(colorString);
                baseLayout.setBackgroundColor(filteredColor);
                } 
           catch (IllegalArgumentException iae) {
                // This color string is not valid
                }            
           }
    }
}