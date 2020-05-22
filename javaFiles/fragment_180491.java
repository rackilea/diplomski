JPAContainer<Person> container = 
     JPAContainerFactory.<Person>makeReadOnly(Person.class, entityManager);

container.addContainerFilter(new Compare.Equal("email", emailInput));
container.addContainerFilter(new Compare.Equal("password", passwordInput));

// Query container size, eg
if(container.size()==1) { ... }