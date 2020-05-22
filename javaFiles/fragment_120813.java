@Override
public void onPartialResults(Bundle partialResults) {
ArrayList<String> matches = results
            .getStringArrayList(SpeechRecognizer.RESULT_RECOGNITION);
 if(matches.size()==0){

        hasSpoken=false;

 }else{

  hasSpoken=true;
  mCountDownTimer.cancel();
       timerRunning=false;
   }
}