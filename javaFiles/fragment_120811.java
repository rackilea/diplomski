public class FinishSpeechRecognizerTimer extends CountDownTimer{

        public FinishSpeechRecognizerTimer(long startTime, long interval){
          super(startTime,interval);

           }

         @Override
         public void onFinish(){

             if(hasSpoken==false){
                speech.cancel();
            }

           timerRunning=false;

          }

         @Override
         public void onTick(long millisUntilFinish){

           //do whatever you want to do

       }
}