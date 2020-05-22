public void startRecognizing(int sampleRate) {
    if (mApi == null) {
        Log.w(TAG, "API not ready. Ignoring the request.");
        return;
    }
    // Configure the API
    mRequestObserver = mApi.streamingRecognize(mResponseObserver);
    SpeechContext.Builder speechBuilder = SpeechContext.newBuilder();
    speechBuilder.addPhrases("E per me");
    speechBuilder.addPhrases("E");
    mRequestObserver.onNext(StreamingRecognizeRequest.newBuilder()
            .setStreamingConfig(StreamingRecognitionConfig.newBuilder()
                    .setConfig(RecognitionConfig.newBuilder()
                            .setLanguageCode(getDefaultLanguageCode())
                            .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
                            .setSampleRateHertz(sampleRate)
                            .addSpeechContexts(speechBuilder)
                            .build())
                    .setInterimResults(true)
                    .setSingleUtterance(true)
                    .build())
            .build());
}