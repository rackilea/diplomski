nameArray.clear();
priceArray.clear();
for (Map.Entry<String, BigDecimal> entry : totals.entrySet()) {
    nameArray.add(entry.getKey());
    priceArray.add(entry.getValue());
}