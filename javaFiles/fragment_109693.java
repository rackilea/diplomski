// Custom list to ensure that one duplicate gets added to a list at most as
// opposed to n-1 instances (only two instances of a value in this list would 
// be deceiving).
List<String> list = new ArrayList<>();
list.add("Apple");
list.add("Ball");
list.add("Ball");
list.add("Ball");
list.add("Ball");
list.add("Cat");
list.add("Cat");
list.add("Cat");
list.add("dog");
list.add("dog");

Set<String> set = new HashSet<>();
Set<String> setOfDuplicates = new HashSet<>();
for (String s : list) {
    if (!set.add(s)) { // Remember that sets do not accept duplicates
        setOfDuplicates.add(s);
    }
}

List<String> listOfDuplicates = new ArrayList<>(setOfDuplicates);