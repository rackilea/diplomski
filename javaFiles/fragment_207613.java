Map<Key,Value>[] dictonaires = new HashMap<Key,Value>[20];
for (int i=0; i<dictionaries.length; i++) {
    dictionaries[i] = new Hashmap<Key,Value>();
}

// Any time later, refer to a dictionary by index 
Map<Key,Value> currentDictionary = dictionaries[10];
// Can call currentDictionar.put/get/remove to create or update/read/delete 
// entries, but can't add/remove entire dictionaries