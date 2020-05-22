private CountDownTimer myTime;

public void startTimer(View view){

    myTime = new CountDownTimer(30000,1000) {

    }
}

public void reset() {
    myTime.cancel();
}