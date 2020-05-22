@Test
 public void testGreetingGenerator() {
      Person mockPerson = mock(Person.class);
      when(mockPerson.getName()).thenReturn("Alan");

      GreetingGenerator greeting = new GreetingGenerator(mockPerson);
      assertEquals("Hello Alan", greeting.getGreeting());
 }