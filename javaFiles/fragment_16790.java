public class DetailsData {
  private String data;
  private BigDecimal amount;
  private List<MoneyValue> amountCurrencyList;

  /*getters, setters, constructors*/

  public DetailsData() {
  }

  @JsonProperty("amountCurrencyList")
  private void deserializeMoneyValue(List<Map<String, Object>> data) {
    if (Objects.isNull(amountCurrencyList)) {
        amountCurrencyList = new ArrayList<>();
    } else {
        amountCurrencyList.clear();
    }        
    MoneyValue moneyValue;
    for (Map<String, Object> item : data) {
      moneyValue = new MoneyValue(getValue(item.get("value")),
          (String) item.get("currency"));
      amountCurrencyList.add(moneyValue);
    }
  }

  private BigDecimal getValue(Object value) {
    BigDecimal result = null;
    if (value != null) {
      if (value instanceof BigDecimal) {
        result = (BigDecimal) value;
      } else if (value instanceof BigInteger) {
        result = new BigDecimal((BigInteger) value);
      } else if (value instanceof Number) {
        result = new BigDecimal(((Number) value).doubleValue());
      } else {
        throw new ClassCastException("Invalid value");
      }
    }
    return result;
  }
}