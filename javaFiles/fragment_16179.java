RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.test);
RelativeLayout.LayoutParams relativeLayoutParams;       
TextView[] textView = new TextView[2];

// 1st TextView
textView[0] = new TextView(this);

relativeLayoutParams = new RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT);

textView[0].setId(1); // changed id from 0 to 1
textView[0].setText("1");   

relativeLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);

relativeLayout.addView(textView[0], relativeLayoutParams);

// 2nd TextView
textView[1] = new TextView(this);

relativeLayoutParams = new RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT);      

textView[1].setText("2");

relativeLayoutParams.addRule(RelativeLayout.RIGHT_OF,
        textView[0].getId());
relativeLayoutParams.addRule(RelativeLayout.ALIGN_TOP,
        textView[0].getId()); // added top alignment rule

relativeLayout.addView(textView[1], relativeLayoutParams);