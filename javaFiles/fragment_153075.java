Person person = null;
while ((line = file.readLine()) != null) {
    person = new Person(line);
    //do
}
System.out.println(person.getSmoker());