` CompletionStage<Void> Function() {
   someOperation
    .thenCompose(variable -> AsyncWriteInDb(variable));
}
//AsyncWriteInDb returns CompletionStage<Void> when write is completed.
`