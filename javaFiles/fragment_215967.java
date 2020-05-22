public FlexibleAccount(double initBal, String owner)
      {
        Random generator = new Random();
         balance = initBal;
        name = owner;
         this.acctNum= generator.nextLong();
        }