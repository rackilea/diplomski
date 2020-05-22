onAndroidTurn(){
    textView1.setVisibility(View.VISIBLE);
    saveMove(calculateNextMove());
    new Handler().postDelayed(new Runnable(){
        void run() {
            textView1.setVisibility(View.GONE);
            doNextMove(restoreMove());
        }
    }, 2000);
}