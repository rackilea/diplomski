mCountDownTimer.cancel();
cdTime = cdTime + 20000;
percentageTime = percentageTime + 20;
//Create a countdown timer with the updated time
mCountDownTimer = new CounDownTimer(cdTime, anInterval){ 
                     /* handle the countdown notifications as you wish, for example like you did in your question */ 
                   }
mCountDownTimer.start();