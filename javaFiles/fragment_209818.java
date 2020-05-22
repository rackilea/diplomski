Map<Set<String>, T> map = HashMap<>();
Set<String> mySet = new HashSet<>();

mySet.add("first");
map.put(mySet, myValue);


Set<String> copyOfMySet = new HashSet<>(mySet);

//returns true
map.contains(copyOfMySet);

//modifying mySet
mySet.remove("first");

//this will now return false
map.contains(copyOfMySet);