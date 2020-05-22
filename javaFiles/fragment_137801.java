@Named
public class TestA{

@Inject
TestB testB;

@Transactional(transactionManager="myJpaTm")
public void methoda() {
   // other db stuff
   if(TransactionSynchronizationManager.isActualTransactionActive()){
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter(){
                 @Override
                 public void afterCommit(){
                     testB.methodb();
                 }
         });
    }
  }
}