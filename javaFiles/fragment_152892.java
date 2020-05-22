customTimer.setTimerListener(new TimerListener(){
    @Override
    public void getTimerTick(long time){
        textView.setText(String.valueOf(time));
    }
});