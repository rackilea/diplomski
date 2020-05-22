public FlexibleAccount(String owner)
    {
     balance = 0;
     name=owner;
     Random generator = new Random();
     number=generator.nextDouble();        << number is not declared
     this.acctNum= number;
     }