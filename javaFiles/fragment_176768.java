@Override
public void onResults(Bundle results) {
    List<String> list=results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
    for(String s: list)
    {
        if(s.contains("Launch camera"))
        {
         dispatchTakePictureIntent()
         // call the function to take picture 
         break;
        }
    }
}