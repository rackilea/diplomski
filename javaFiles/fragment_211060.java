@Aspect
 class TransactionAspect extends TransactionSynchronizationAdapter {

   @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
   public void registerTransactionSyncrhonization() {
       TransactionSynchronizationManager.registerSynchronization(this);

   }

   ThreadLocal<Long> startTime = new ThreadLocal<>();

   void beforeCommit() {
       startTime.set(System.nanoTime());
   }
   void afterCommit(){
       System.out.println("Transaction time: " + (System.nanoTime() - startTime.get()));
   }
}