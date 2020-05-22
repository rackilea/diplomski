Set <Map.Entry<String, HashMap<String, String>>> entrySet =
        listings.entrySet();
ArrayList<Map.Entry<String, HashMap<String, String>>> entryArr =
    new ArrayList<Map.Entry<String, HashMap<String, String>>> (entrySet);

for (int i = 0; i < arr.size(); i++) {
    for (int j = i; j < arr.size(); j++) {
         // something; use arr.get(i), arr.get(j) to get at the keys/values
    }
}