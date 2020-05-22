int valuesIndex = 0;
for (String country: X_AxesList) {
    Map<Object, Object> map1 = new LinkedHashMap<>();
    map1.put("Country", country);
    for (String year: Y_AxesList) {
        map1.put(year, ValueList.get(valuesIndex++));   
    }
    dataProviderList.add(map1);
}