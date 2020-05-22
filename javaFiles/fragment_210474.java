Observable.mergeDelayError(listOfObservables)
  .subscribe(
    (v) -> {}, // for every successfull item
    (e) -> {}, // after all completed and at least one errored
    () -> {}  // after all completed, won't be called on error though
  );