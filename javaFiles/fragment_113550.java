public static void main(String[] args) {
    // init here (getting dao and transaction template)
    transactionTemplate.execute(new TransactionCallback() {
        @Override
        public Object doInTransaction(TransactionStatus status) {
          // save here
        }
    }

    transactionTemplate.execute(new TransactionCallback() {
        @Override
        public Object doInTransaction(TransactionStatus status) {
          // list here
        }
    }
}