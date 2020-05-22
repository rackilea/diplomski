private Map currencyMap;

public CurrencyData() {
    currencyMap = new HashMap();
}

public void setCurrencyValue(String key, String value) {
    currencyMap.put(key, value);
}

public String getCurrencyValue(String key) {
    return currencyMap.get(key).toString();
}