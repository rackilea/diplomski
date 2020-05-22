EditText hi = findViewById(R.id.textView2);
Bundle extras = getIntent().getExtras();
//always true
if (extras != null) {
    // sum is set with right value
    int sum = getIntent().getIntExtra("RESULT_SUM", 0);

    //textView2 display the right sum
    hi.setText(String.valueOf(sum));
}


EditText bye = findViewById(R.id.textView2);
Bundle extra = getIntent().getExtras();

//always true
if (extras != null) {
    //no result_sumd found
    //sumd == 0
    int sumd = getIntent().getIntExtra("RESULT_SUMd", 0);

    //textView2 text is override with 0, value of sumd
    bye.setText(String.valueOf(sumd));
}