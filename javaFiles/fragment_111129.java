RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

    TextView txt1 = new TextView(this);
    txt1.setText("Hello world");
    txt1.setTextColor(Color.BLACK);
    TextViewCompat.setTextAppearance(txt1, android.R.style.TextAppearance_Large);

    TextView txt2 = new TextView(this);
    txt2.setText("Bonjour le monde");
    txt2.setTextColor(Color.BLACK);
    TextViewCompat.setTextAppearance(txt2, android.R.style.TextAppearance_Medium);

    txt1.setId(View.generateViewId());
    txt2.setId(View.generateViewId());

    rlp.setMargins(0, 0, 0, 20);
    rlp.addRule(RelativeLayout.BELOW, txt1.getId());
    txt2.setLayoutParams(rlp);

    relativelayout.addView(txt1);
    relativelayout.addView(txt2);