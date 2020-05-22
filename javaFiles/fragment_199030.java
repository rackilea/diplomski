@Test
public void getValueTest() {
    Stock stock = new Stock(100.00, 200);
    double value = stock.getValue();
    assertEquals("Stock value not correct", 100.00*200, value, .00001);
}