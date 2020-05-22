Maps.transformEntries(pkgPrice,
    new EntryTransformer<OccupancyType, BigDecimal, BigDecimal>() {
  public BigDecimal transformEntry(OccupancyType key, BigDecimal pkPrice) {
    return pkPrice.add(filteredPrice.get(key));
  }
});