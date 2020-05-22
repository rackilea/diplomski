List<Entry<Integer, String>> entries = new ArrayList<>();

//this is a compile error, but assume it is possible
List<Entry<?, String>> wildcardEntries = entries; 

//then since this is already possible
wilcardEntries.add(new Entry<String, String>("a", "b"));
Entry<Integer, String> entry1 = entries.get(0);

//this would result in a type error (ClassCastException)
Integer i = entry1.getKey();