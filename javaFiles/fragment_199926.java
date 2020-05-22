Map<String, List<Object>> hm = new HashMap<String, List<Object>>();
for (String key : hm.keySet()) {
    // gets the value
    List<Object> value = hm.get(key);
    // checks for null value
    if (value != null) {
        // iterates over String elements of value
        for (Object element : value) {
            // checks for null 
            if (element != null) {
                // prints whether the key is equal to the String 
                // representation of that List's element
                System.out.println(key.equals(element.toString()));
            }
        }
    }
}