findViewById(R.id.button1).setOnClickListener(new OnClickListener(){
     public void onClick(View v) {
         findViewById(R.id.hiddenview).setVisibility(View.GONE);
         findViewById(R.id.relativelayout).invalidate();
     }
});
findViewById(R.id.button2).setOnClickListener(new OnClickListener(){
     public void onClick(View v) {
         findViewById(R.id.hiddenview).setVisibility(View.VISIBLE);
         findViewById(R.id.relativelayout).invalidate();
     }
});