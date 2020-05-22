LinearLayout rootLayout = (LinearLayout)findViewById(R.id.root_layout);

LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
params.gravity = Gravity.RIGHT;

ImageView btnSend = new ImageView (this); 
btnSend.setLayoutParams(params);
rootLayout.addView(btnSend);