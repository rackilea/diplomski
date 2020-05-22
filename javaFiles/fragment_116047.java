RecognitionProgressView recognitionProgressView = (RecognitionProgressView) findViewById(R.id.recognition_view);
recognitionProgressView.setSpeechRecognizer(speechRecognizer);
recognitionProgressView.setRecognitionListener(new RecognitionListenerAdapter() {
    @Override
    public void onResults(Bundle results) {
        showResults(results);
    }
});