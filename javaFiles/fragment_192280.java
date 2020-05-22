public void testBalanceAfterTenPoundDeposit() {
   // note the interface/impl separation so I can test different
   // implementations with the same interface (this is Test By Contract)
   CurrentAccount ca = new CurrentAccountImpl();

   // check the starting balance
   Assert.assertEquals(ca.settlement(), 0);

   // deposit
   ca.deposit(10);

   // do I have £10 ?
   Assert.assertEquals(ca.settlement(), 10);
}