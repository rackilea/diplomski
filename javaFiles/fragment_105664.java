@Test
public void testGetBalanceForPerson() {

   // creating mock person
   Person person1 = mock(Person.class);
   when(person1.getId()).thenReturn("mockedId");

   // calling method under test
   try {
      myClass.getBalanceForPerson(person1);
   } catch(Exception e) {
      fail("Should not have thrown any exception");
   }
}