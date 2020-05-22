HashMap<String, Integer> myMap = new HashMap<String, Integer>();

for (... record : records) {
    String countryCode = record.getCountryCode();

    int curVal;
    if (myMap.containsKey(countryCode)) {
        curVal = myMap.get(countryCode);
        myMap.put(countryCode, curVal + 1);
    } else {
        myMap.put(countryCode, 1);
    }
}

// myMap now contains the count of each country code, which
// can be used for whatever purpose needed.