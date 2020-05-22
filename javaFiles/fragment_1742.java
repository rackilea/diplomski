...
private Stream myStream;
... 
@PostConstruct
private void startStream() {
    this.myStream = twitter.streamingOperations().filter(parameters, tweetStreamListeners);

private void closeStream() {
    this.myStream.close();
}