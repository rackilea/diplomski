List<String> myList = new ArrayList<>();
myList.add("AFIxyz boo");
myList.add("Foo Bar");
myList.add("Bar Baz");
myList.add("AFI afi");
myList.add("Edit this template");
myList.add("Watch");

System.out.println("Before removing:");
System.out.println(myList);

//remove all which start with "AFI"
myList.removeIf(s -> s.startsWith("AFI"));

//remove all which have more than two words
myList.removeIf(s -> s.split(" ").length > 2);

System.out.println("\nAfter removing:");
System.out.println(myList);