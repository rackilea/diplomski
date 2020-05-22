private void count() {
   TextView textView=(TextView)findViewById(R.id.textView);
   int i;
   i=1;
   while(i<10) {
       i++;
       textView.setText("" + i);
       try {
           Thread.sleep(200);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }
}