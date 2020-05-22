// here the first name, last name, and username may be null 
// or not null. Make sure that they are not all at the same time
String firstName = "James";
String lastName = null;
String userName = "jbond";

Example<User> example = Example.of(new User(firstName, lastName, username));
Iterable<User> = repository.findAll(example);