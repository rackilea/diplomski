List<Person> jonesFamily = new ArrayList<>();
Person.Builder builder = new Person.Builder().setLastName("Jones");

for(String firstName : jonesFamilyFirstNames) {
  family.add(builder.setFirstName(firstName).build());
}