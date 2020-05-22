Bundle bundle = getIntent().getExtras();

    //Extract the data…
    String something = bundle.getString("TAG");        

    //Create the text view
    TextView textView = new TextView(this);
    textView.setText(TAG);