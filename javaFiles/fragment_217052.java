@Test
public void testJsonRoundtrip() throws IOException {
    final FilterProvider filters = new SimpleFilterProvider().addFilter("allFilter", allFilter);
    final EODPrice eodPriceWithAll = new EODPrice(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE);
    final EODPrice eodPriceWithoutAll = new EODPrice(BigDecimal.TEN, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE);

    final ObjectMapper mapper = new ObjectMapper();
    mapper.setFilters(filters);

    // First, test serialization
    final String eodWithAllAsStr = mapper.writeValueAsString(eodPriceWithAll);
    final String eodWithoutAllAsStr = mapper.writeValueAsString(eodPriceWithoutAll);

    Assert.assertTrue(eodWithAllAsStr.contains("all"));
    Assert.assertFalse(eodWithoutAllAsStr.contains("all"));

    // Then, test deserialization
    final EODPrice eodPriceWithAll2 = mapper.readValue(eodWithAllAsStr, EODPrice.class);
    final EODPrice eodPriceWithoutAll2 = mapper.readValue(eodWithoutAllAsStr, EODPrice.class);

    Assert.assertTrue(eodPriceWithAll2.allFieldsEqual());
    Assert.assertFalse(eodPriceWithoutAll2.allFieldsEqual());
}