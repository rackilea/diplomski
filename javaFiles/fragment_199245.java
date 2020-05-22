Collection<String> mySet = new HashSet<>();
mySet.addAll(Arrays.asList("A", "B", "C"));
for (String myString : mySet) {
    if (myString.equals("B")) {
        mySet.remove(myString);
    }
}