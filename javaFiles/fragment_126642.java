public void replace(File inputFile, String newName) {
  List<Person> persons = new ArrayList<Person>();

  // read the file
  List<String> lines = readFile(inputFile);

  // create a person instance for each line
  for (String line:lines) {
    String[] values = line.split(">");
    persons.add(new Person(values));
  }

  // change the last name
  for (Person person:persons) {
    person.setLastName(newName);
  }

  // store all persons to file
  writeFile(inputFile, persons);
}