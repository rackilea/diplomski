public void buttonOnClick(View v) {
     Button button=(Button) v;
     ((Button) v).setText("Correct");
     new android.os.Handler().postDelayed(new Runnable() {
         @Override
         public void run() {
             finish();
         }
     },1000); // milliseconds: 1 seg.
}