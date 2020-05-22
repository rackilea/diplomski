public FlexibleAccount(double initBal, String owner, double number)
  {
    Random generator = new Random();
     balance = initBal;
    name = owner;
     number=generator.nextDouble();
     this.acctNum= number;
    }