public boolean textToSpeechIsInitialized = false;  // <--- add this line

public void onInit(int status) {
    if (status == TextToSpeech.SUCCESS) {

        textToSpeechIsInitialized = true;  // <--- add this line

        int result = textToSpeech.setLanguage(Locale.US);

        if (result == TextToSpeech.LANG_MISSING_DATA
                || result == TextToSpeech.LANG_NOT_SUPPORTED) {
            Log.e("TTS", "This Language is not supported");
        } else {
           speakOut("badr","dfd");
        }

    } else {
        Log.e("TTS", "Initilization Failed!");
    }
}