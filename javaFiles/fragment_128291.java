Person person = new Person("Rob"); // create a new Object

List<Person> myList = new ArrayList<Person>();
myList.add(person);

// Create another list accepting the first one
List<Person> myList2 = new ArrayList<Person>(myList);

for(Person p : myList2) {
    p.setName("John"); // Update mutable object in myList2
}

person = new Person("Mary"); // stick another object into myList2
myList2.add(person);

for(Person p : myList2) {
    System.out.println(p.getName()); // prints John and Mary as expected
}

for(Person p : myList) {
    System.out.println(p.getName()); // prints only one result, John.
}