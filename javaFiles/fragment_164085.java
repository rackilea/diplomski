List<String> list = new ArrayList<>();
list.add("one"); list.add("two"); list.add("three"); // Make a list of 3 elements
String allStrings = ""; // This will have all the elements of the collection
// Iterate the list collection and get each element and concatenate
for (String ele : list) {
    allStrings = allStrings + ele;
}
System.out.println(allStrings); // This prints: onetwothree