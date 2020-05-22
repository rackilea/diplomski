final CountDownTimer finalTimer = new CountDownTimer(1000, 1000){
    public void onTick(long l){
        //do Stuff
    }
    public void onFinish(){
        //doStuff
    }
};    
final CountDownTimer theTimer = new CountDownTimer((cdTime), 1000){    
    public void onTick(long millisUntilFinished){    
        button.setText(String.valueOf(millisUntilFinished));
        if(millisUntilFinished <= 10000){
            button.setVisibility(View.GONE);
        }    
    }    
    public void onFinish(){    
        finalTimer.start();    
    }
}.start();