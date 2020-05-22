LinearLayout Main_layout=(LinearLayout)findViewById(R.id.main_layout);
    RelativeLayout wrapper = (RelativeLayout)findViewById(R.id.wrapper);
    wrapper.removeView(Main_layout);
    LinearLayout linearLayout=new LinearLayout(this);
    LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
    layoutParams.setMargins(0, 25, 0, 0);
    linearLayout.addView(Main_layout, layoutParams);
    wrapper.addView(linearLayout);
    //more code