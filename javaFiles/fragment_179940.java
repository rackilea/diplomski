SpeechToText service = new SpeechToText();
service.setUsernameAndPassword("<username>", "<password>");

FileInputStream audio = new FileInputStream("path-to-audio-file.flac");

RecognizeOptions options = new RecognizeOptions.Builder()
  .continuous(true)
  .interimResults(true)
  .contentType(HttpMediaType.AUDIO_FLAC)
  .build();

service.recognizeUsingWebSocket(audio, options, new BaseRecognizeCallback() {
  @Override
  public void onTranscription(SpeechResults speechResults) {
    System.out.println(speechResults);
  }
});