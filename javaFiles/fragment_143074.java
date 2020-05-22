Map<Person, String> map = new HashMap<>();
Person person = new Person("Foo", 100);
map.put(person, "Some value");

// If this changes the result of hashCode()...
person.addFriend(new Friend("Bar"));
// ... then you may not be able to find even the same object in the map.
System.out.println(map.get(person));