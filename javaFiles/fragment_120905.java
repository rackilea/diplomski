final CircleProgress circularProgress =(CircleProgress)findViewById(R.id.circleProgress);

//Hides the text and the part of the circle which should not be shown
circularProgress.setUnfinishedColor(Color.parseColor("#00000000"));
circularProgress.setTextColor(Color.parseColor("#00000000"));

//Makes the circle red
circularProgress.setFinishedColor("#FF0000");

final int timeToCountDownMilis = 10000;
circularProgress.setMax(timeToCountDownMilis);

//Initiates and starts the countdowntimer which gradually increases the "progress" in the progress bar
new CountDownTimer(timeToCountDownMilis,70){

    onTick(long milisUntilFinished){
       circularProgress.setProgress(timeToCountDownMilis-(int)milisUntilFinished);
    }

    onFinish(){
    }
}.start();