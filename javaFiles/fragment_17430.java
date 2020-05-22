LinearLayout linearLayout = new LinearLayout(context);
RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
params.addRule(RelativeLayout.CENTER_VERTICAL);
linearLayout.setOrientation(LinearLayout.VERTICAL);
linearLayout.setGravity(Gravity.CENTER_VERTICAL); //not sure it's needed
linearLayout.setLayoutParams(params);