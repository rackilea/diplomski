t = (TextView) findViewById(R.id.textViewId);
t.setLines(3);

btn.setOnClickListener(new OnClickListener() {          
   @Override
   public void onClick(View v) {
      t.setLines(8);
   }
});