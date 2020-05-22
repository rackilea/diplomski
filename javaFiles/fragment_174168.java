public void onResults(Bundle results) {
speechResult = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
if(speechResult!=null){
    if(speechResult.size()>0 ){
        String command=speechResult.get(0).toString();
                 }
         }