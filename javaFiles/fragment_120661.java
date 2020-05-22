public BigInteger getNumber(final int index) 
    throws InterruptedException, ExecutionException {
   if (index == 0 || index == 1)
     return BigInteger.valueOf(index + 1);

   return getNumber(index - 1).add(getNumber(index - 2));
}