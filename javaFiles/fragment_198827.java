`CompletionStage<Void> Function() {
   someOperation
    .thenAccept(variable -> {
       AsyncWriteInDb(variable);
       return;
    });
}
// thenAccept's lamda was returning after initiating an asyncDbWrite.
// Reading just after this doesnt ensure sequential reading after writing.
`