int number =0;
if(getIntent().getExtras()!=null){
number = Integer.parseInt(getIntent().getStringExtra("number"));
}
LinearLayout ll= findViewById(R.id.ll_layout);
for (int i = 0; i < num; i++) {
    final TextView tv_text= new TextView(this);
    tv_text.setText("Value " + i);
    ll.addView(tv_text);
}