List<Map<Key,Value>> dictionaryList = new ArrayList<Map<Key,Value>>();

// Then add new dictionary anytime later:
dictionaryList.add(new HashMap<Key,Value>());    

// Access by index (index matches order of adding):
Map<Key,Value> currentDictionary = dictionaryList.get(10);    
// Can call currentDictionar.put/get/remove to create or update/read/delete 
// entries, but can't add/remove entire dictionaries

// Or even remove entire dictionary by index:
dictionaryList.remove(10);