Map<String, MyMotherClass<?>> myCollection = new HashMap<String, MyMotherClass<?>>();
Map<String, AbstractItem> myItems = new HashMap<String, AbstractItem>();

// fill the 2 collections

MyMotherClass<?> child = myCollection.get("key");
child.setItem(myItems.get("key2"));