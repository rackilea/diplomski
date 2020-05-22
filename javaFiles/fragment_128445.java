@Test
public void jsonSerializationTest() throws Exception {
     MoneyBean m = new MoneyBean();
     m.setAmount(new BigDecimal("20.3"));

     ObjectMapper mapper = new ObjectMapper();
     assertEquals("{\"amountOfMoney\":\"20.30\"}", mapper.writeValueAsString(m));
}