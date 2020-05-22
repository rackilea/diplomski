`CompletionStage<Void> Function() {
   someOperation
    .thenAccept(variable -> AsyncWriteInDb(variable));
}
// AsyncWriteInDb returns CompletionStage<Void> when write is completed.
// I was reading just after execution of this function. 
`