@Before
 public void setUp() {
      mockPerson = mock(Person.class);
      when(mockPerson.getName()).thenReturn("Alan");
 }

 @Test
 public void testGreetingGenerator() {
      GreetingGenerator greeting = new GreetingGenerator(mockPerson);
      assertEquals("Hello Alan", greeting.getGreeting());
 }