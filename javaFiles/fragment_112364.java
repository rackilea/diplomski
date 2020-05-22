@Test
public void testSetName() {
    Person person = new Person();
    person.setName("Larry");
    assertEquals("Larry", person.getName()); 
}