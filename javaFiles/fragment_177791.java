@Test
public void testResetVendingBalance()  {
    Vending vending = new Vending(0,0);
    vending.addMoney(7);
    vending.resetBalance();
    assertEquals("Test if vending reset.",0, vending.getBalance(), 0);
}

@Test
public void testAddVendingBalance()  {
    Vending vending = new Vending(0,0);
    vending.addMoney(7);
    assertEquals("Test money amount.",7, vending.getBalance(), 0);
}