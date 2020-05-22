Bundle bundle = getIntent().getExtras();

TextView textView = (TextView)findViewById(R.id.txt);
textView.setText(bundle.getCharSequence("rg"));

TextView textView1 = (TextView)findViewById(R.id.txt1);
textView1.setText(bundle.getCharSequence("rg1"));

TextView textView2 = (TextView)findViewById(R.id.txt2);
textView2.setText(bundle.getCharSequence("rg2"));

TextView textView3 = (TextView)findViewById(R.id.txt3);
textView3.setText(bundle.getCharSequence("rg3"));

TextView textView4 = (TextView)findViewById(R.id.txt4);
textView4.setText(bundle.getCharSequence("rg4"));

TextView textView5 = (TextView)findViewById(R.id.txt5);
textView5.setText(bundle.getCharSequence("rg5"));

TextView textView6 = (TextView)findViewById(R.id.txt6);
textView6.setText(bundle.getCharSequence("rg6"));