public class Repository implements IRepository{
    @Transactional
        public void save(Op op) {
            System.out.println("Transaction active:::: " + TransactionSynchronizationManager.isActualTransactionActive());

    ...
    }
}