String mySearchString = "mySearchString";
Map<String, Collection<String>> multiMap = new HashMap<>();
for (String key : multiMap.keySet()) {
    if (multiMap.get(key) != null && multiMap.get(key).contains(mySearchString)) {
        return key;
    }
}