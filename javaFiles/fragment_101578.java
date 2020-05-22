List<User> users = new ArrayList<>();
while(someValue) {
   ...
   int id = ...
   String firstName= ...
   String lastName = ...
   User user = new User();
   user.setId(id);
   user.setFirstName(firstName);
   user.setLastName(lastName);
   users .add(user);
}

// after do what you want with the list