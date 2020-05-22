Handler mHandler = new android.os.Handler();
int temp_score = 0;
int i = 0;
while(temp_score<=score){
    final String score_string = "" + temp_score++;
    mHandler.postDelayed(new Runnable(){
        public void run() {
            scoreTextView.setText(score_string);
        }
    }, ++i*1000);
}