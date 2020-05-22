public static void main(String[] args) {
    // init here (getting dao and transaction template)

    transactionTemplate.execute(new TransactionCallback() {
        @Override
        public Object doInTransaction(TransactionStatus status) {
          // do your hibernate stuff in here : call save, list method, etc
        }
    }
}