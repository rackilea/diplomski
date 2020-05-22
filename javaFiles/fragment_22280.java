// Student class implements Clonable
Student rookieStudentPrototype = new Student();
rookieStudentPrototype.setStatus("Rookie");
rookieStudentPrototype.setYear(1);

// By using prototype pattern here we don't need to re-set status and
// year, only the name. Status and year already copied by clone
Student tom = rookieStudentPrototype.clone();
tom.setName("Tom");

Student sarah = rookieStudentPrototype.clone();
sarah.setName("Sarah");