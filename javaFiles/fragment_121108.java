public void onInit(int status) {
    if (status == TextToSpeech.SUCCESS) {
        int result = tts.setLanguage(Locale.US);
        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
            Log.e("TTS", "This Language is not supported");
        } else {
            // btnaudioprayer.setEnabled(true);
            speakOut();
        }
    } else {
        Log.e("TTS", "Initilization Failed!");
    }
}