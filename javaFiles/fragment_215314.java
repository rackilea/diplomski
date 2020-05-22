List<List<String>> allTheStrings = new ArrayList<List<String>>();

List<String> myStrings = null;

// Add a subset
myStrings = new ArrayList<String>();
myStrings.add("something");
myStrings.add("something");
myStrings.add("something");
allTheStrings.add(myStrings);

// Add another subset
myStrings = new ArrayList<String>();
myStrings.add("something");
myStrings.add("something");
myStrings.add("something");
allTheStrings.add(myStrings);


...

// Obtain one of the strings
String str = allTheStrings.get(1).get(2);