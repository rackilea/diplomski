List<String> list = new ArrayList<String>();
list.add("How are you");
list.add("How you doing");
list.add("Joe");
list.add("Mike");

Collection<String> filtered = Collections2.filter(list,
    Predicates.containsPattern("How"));
print(filtered);