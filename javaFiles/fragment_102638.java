String max = countryToAvgTemp.entrySet().stream()      //stream all entries
    .max(Map.Entry.comparingByValue())                 //get the max by comparing entry value
    .map(Map.Entry::getKey)                            //grab the key   
    .orElseThrow(() -> new RuntimeException("No max")); //e.g. if the list is empty

String min = countryToAvgTemp.entrySet().stream()
    .min(Map.Entry.comparingByValue())
    .map(Map.Entry::getKey)
    .orElseThrow(() -> new RuntimeException("No min"));