@Test
public void singleEmployeeAddedToList() throws Exception{
    Employees toTest = new Employees();
    Person testSubject = new Person("John", "Smith");
    toTest.addNewEmployee(testSubject);

    assertEquals(Collections.singletonList(testSubject), toTest.getPersons());
}