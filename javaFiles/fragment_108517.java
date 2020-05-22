private Handler mHandler;
protected void onCreate(Bundle savedInstanceState) {
    mHandler = new Handler();
}
...
private OnClickListener CheckAnswer = new OnClickListener() {
     public void onClick(View view) {
       // fix up view
       mHandler.postDelayed(new Runnable() {
           @Override
           public void run() {
               questionGenerator();
           }
       }, 10000);
   }
}