private void count() {
   TextView textView=(TextView)findViewById(R.id.textView);

   for(int i = 1; i < 11; i++){ // From 1 to 10
       textView.setText("" + i);
       Thread.sleep(200); 
   }
}