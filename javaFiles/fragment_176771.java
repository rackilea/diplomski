String inputcommand="";

@Override
public void onResults(Bundle results) {
    List<String> list=results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
    for(String s: list)
    {
        if(s.contains("Launch camera"))
        {
            // store your match in global variable to use it later
            inputcommand = s;

            dispatchTakePictureIntent()
            // respond it first  
         break;
        }
    }
}