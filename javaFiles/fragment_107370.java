TextView t1 = (TextView)findViewById(R.id.t1);
    LinearLayout mainLinear = (LinearLayout)findViewById(R.id.mainLinear);

    try {
        LinearLayout linear = (LinearLayout)findViewById(R.id.scroll_container);
        linear.setBackgroundColor(0xABCDEFFE);

        TextView []tv = new TextView[10];

        for (int i = 0; i < 10; i++) {

            tv[i] = new TextView(getApplicationContext());

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            tv[i].setLayoutParams(params);

            tv[i].setTextSize(25);
            tv[i].setId(i);
            tv[i].setTextColor(Color.BLACK);
            tv[i].setPadding(10, 10, 10, 10);
            tv[i].setBackgroundColor(Color.WHITE);
            tv[i].setText("I am serial 4 " + i + "\n" + "is there something more");
            linear.addView(tv[i]);
        }
    }
    catch (Exception e)
    {
        e.printStackTrace();
        t1.setText(value+"<><>"+e);
    }