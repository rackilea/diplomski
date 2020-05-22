private updateDB() {
   TransactionTemplate transaction = ... // get it somehow;
   transaction.execute(new Callable<Void>(){

        // will be executed in a transaction
        public Void call() throws Exception {
            //do some DB stuff  
        }
   });
}