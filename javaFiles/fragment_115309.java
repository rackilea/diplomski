Entry<String, String>[] array = new Entry<String, String>[ isoMap.size() ];
Object[] objArray = array;

// Does not throw an ArrayStoreException.
objArray[0] = new AbstractMap.SimpleEntry<>(Integer.valueOf(0), Integer.valueOf(0));
String key = array[0].getKey();