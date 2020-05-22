@Transient
private Map<String, CountryName> countryNameMap;
...
public CountryName getName(String countryCode) {
    if (countryNameMap == null) {
        countryNameMap = loadNamesIntoMap(); // a loop with countryNameMap.put(countryName.getCountryCode(), countryName)
    }
    return countryNameMap.get(countryCode);
}