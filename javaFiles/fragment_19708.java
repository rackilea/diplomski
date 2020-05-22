ArrayList<Employee> employees = new ArrayList<Employee>();
for(Person person : personList) {
  for(PersonNpi personNpi : npiList) {
    if (person.getName().equals(personNpi.getName()) && 
        person.getAddress().checkEquality(...address parts here...)) {
      employees.add(new Employee(person, personNpi));
    }
  }
}