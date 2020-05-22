String[] arr = yourStringArray; //wherever your Strings are coming from
Map<String, Integer> strCounts = new HashMap<String, Integer>; //this stores the strings you find
for (int i = 0; i < arr.length; i++) {
    String str = arr[i];
    if (strCounts.containsKey(str)) {
        strCounts.get(str) += 1; //if you've already seen the String before, increment count
    } else {
        strCounts.put(str, 1); //otherwise, add the String to the HashMap, along with a count (1)
    }
}