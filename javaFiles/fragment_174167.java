private SpeechRecognizer speech = null;
private Intent speechIntent=null;

/**
 * Speech Result is used to Store the Voice Commands
 */
private ArrayList<String> speechResult;


inside onCreate()  --- > 

 speech = SpeechRecognizer.createSpeechRecognizer(this);
 speech.setRecognitionListener(this);


  Trigger this after your button Click: 

       if (SpeechRecognizer.isRecognitionAvailable(this)) {
            if(speechIntent==null ){
                speechIntent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                speechIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE, "en");
                speechIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, this.getPackageName());
                speechIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
                speechIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,12);
                speech.startListening(speechIntent);
            }else{
                if(speech!=null){
                    speech.startListening(speechIntent);
                }
            }
        }