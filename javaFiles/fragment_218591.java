/**
 * create JavaBean
 */
public void testGetBeanAssumeClass() {
    String data = "--- !!org.yaml.snakeyaml.constructor.Person\nfirstName: Andrey\nage: 99";
    Object obj = construct(data);
    assertNotNull(obj);
    assertTrue("Unexpected: " + obj.getClass().toString(), obj instanceof Person);
    Person person = (Person) obj;
    assertEquals("Andrey", person.getFirstName());
    assertNull(person.getLastName());
    assertEquals(99, person.getAge().intValue());
}

/**
 * create instance using constructor arguments
 */
public void testGetConstructorBean() {
    String data = "--- !!org.yaml.snakeyaml.constructor.Person [ Andrey, Somov, 99 ]";
    Object obj = construct(data);
    assertNotNull(obj);
    assertTrue(obj.getClass().toString(), obj instanceof Person);
    Person person = (Person) obj;
    assertEquals("Andrey", person.getFirstName());
    assertEquals("Somov", person.getLastName());
    assertEquals(99, person.getAge().intValue());
}