EditText hi = findViewById(R.id.textView2);
    Bundle extras = getIntent().getExtras();
    if (extras != null) {

        int sum = getIntent().getIntExtra("RESULT_SUM", 0);

        hi.setText(String.valueOf(sum));
    }


    EditText bye = findViewById(R.id.textView2);
    Bundle extra = getIntent().getExtras();
    if (extras != null) {

        int sumd = getIntent().getIntExtra("RESULT_SUMd", 0);

        bye.setText(String.valueOf(sumd));
    }