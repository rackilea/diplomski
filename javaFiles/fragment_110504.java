/**
   * See http://stackoverflow.com/q/40244526/328275
   */
  @Test
  public void test3() {
    final MonetaryAmountFormat format = MonetaryFormats.getAmountFormat(
      AmountFormatQueryBuilder.of(Locale.US)
        .set(CurrencyStyle.SYMBOL)
        .build()
    );
    final String actual = format.format(AMOUNT);
    assertEquals(EXPECTED, actual);
  }