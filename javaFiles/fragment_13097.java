@Test
public void testFormatRoundedUp() {
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    formatter.setMaximumFractionDigits(0);
    formatter.setCurrency(Currency.getInstance("USD"));

    double decimal = 1 / 100.0;
    BigDecimal decimalValue = new BigDecimal(decimal);

    Assert.assertThat("Format: 0.01", formatter.format(decimalValue.setScale(0, RoundingMode.UP)), equalTo("US$ 1"));
}