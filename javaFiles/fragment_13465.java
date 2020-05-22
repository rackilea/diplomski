// set the layout file:
    setContentView(R.layout.activity_display_message);

    // get a reference to the layout:
    RelativeLayout rl = (RelativeLayout) findViewById(R.id.display_layout);

    // create your new textview:
    TextView textView = new TextView(this);
    textView.setTextSize(40);
    textView.setText(message);

    // set the TextView to display top left:
    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
    params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
    params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);

    // add the view to layout:
    rl.addView(textView, params);