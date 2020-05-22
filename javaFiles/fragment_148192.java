Collections.sort(list, new Comparator<AccountTransactions>() {

        @Override
        public int compare(AccountTransactions o1, AccountTransactions o2) {

          return o1.getTransactionDate().compareTo(o2.getTransactionDate());
        }  
    });