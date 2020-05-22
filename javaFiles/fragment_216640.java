LinearLayout ll = new LinearLayout(this);
ll.setOrientation(LinearLayout.VERTICAL);

LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
     LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

layoutParams.setMargins(30, 20, 30, 0);

Button okButton=new Button(this);
okButton.setText("some text");
ll.addView(okButton, layoutParams);