goButtonClicks.flatMap(theVoid -> {
   return Observable.zip(
      test1.subscribeOn(Schedulers.io()),
      test2.subscribeOn(Schedulers.io()),
      (v1, v2) -> {
         if (v1 and v2 pass all your requirements) {
            return fireTransaction;
         } else {
            return Observable.just(new TransactionFailure("error"));
         }
      }
   );
}).subscribe(transactionResult -> {
   UI.showMessage(transactionResult.getMessage());
})