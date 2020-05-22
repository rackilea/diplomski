TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization(){

       long startTime;

       void beforeCommit() {
           startTime = System.nanoTime();
       }
       void afterCommit(){
           System.out.println("Transaction time: " + (System.nanoTime() - startTime));
       }
});