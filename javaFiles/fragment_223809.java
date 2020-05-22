final LinearLayout lm = (LinearLayout) findViewById(R.id.linearLayout1);
    LinearLayout ll = new LinearLayout(this);
    ll.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    ll.setWeightSum(1);
    ll.setOrientation(LinearLayout.HORIZONTAL);


    final CheckBox box = new CheckBox(this);
    box.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, .1f));

    final TextView tv = new TextView(this);
    tv.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, .3f));
    tv.setText("STD_MOBILE");

    LinearLayout l2 = new LinearLayout(this);
    l2.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, .6f));
    l2.setGravity(Gravity.RIGHT);
    l2.setOrientation(LinearLayout.HORIZONTAL);


    final Spinner spinner = new Spinner(this);
    spinner.setOnItemSelectedListener(this);
    ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(dataAdapter);
    spinner.setEnabled(false);


    l2.addView(spinner);

    ll.addView(box);
    ll.addView(tv);
    ll.addView(l2);
    lm.addView(ll);