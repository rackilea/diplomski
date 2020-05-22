void doCompare() 
    {
       BigInteger x = new BigInteger("5");
       BigInteger y = new BigInteger("10");

       boolean result = x.compareTo(y) < 0 ? funcA() : funcB();
    }

    boolean funcA(){return true;};
    boolean funcB(){return false;};