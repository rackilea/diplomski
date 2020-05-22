TextView textView = new TextView(this);

    //set layout weight like this where 0.5 f is layout_weight
    LayoutParams params = new LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT, 0.5f); 
        params.setMargins(10, 0, 5, 0);
        textView.setLayoutParams(params);
        textView.setBackgroundColor(Color.WHITE);
        textView.setGravity(Gravity.CENTER);
        textView.setText("Text");