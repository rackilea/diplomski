for(String s : locations){
 Button button = new Button(this);
 button.setText(s);
 button.setId(ID);
 LinearLayout mylayout = (LinearLayout)findViewById(R.id.location_layout); mylayout.setOrientation(LinearLayout.VERTICAL);
 LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.La‌​youtParams.WRAP_CONTENT);
 params.setMargins(0, marginTop, 0, 0);
 button.setLayoutParams(params);
 mylayout.addView(button);
 marginTop += 5;
 ID++; 
}