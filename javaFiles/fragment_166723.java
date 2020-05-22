LinearLayout linearLayout = new LinearLayout(this);
linearLayout.setOrientation(LinearLayout.HORIZONTAL);

LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
     LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

layoutParams.setMargins(10, 10, 10, 10);

Button button = new Button(getActivity());
button.setText("My Button");
linearLayout.addView(button, layoutParams);