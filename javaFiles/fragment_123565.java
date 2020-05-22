final Collaborator anyInstance = new Collaborator();

// Not mocked, as no constructor expectations were recorded:
Collaborator c1 = new Collaborator();
Collaborator c2 = new Collaborator(150);
Collaborator c3 = new Collaborator(150, 20);

new Expectations(Collaborator.class) {{
   anyInstance.getValue(); result = 123;
}};

// Mocked, as a matching method expectation was recorded:
assertEquals(123, c1.getValue());
assertEquals(123, c2.getValue());
assertEquals(123, c3.getValue());

// Not mocked:
assertTrue(c1.simpleOperation(1, "b", null));
assertEquals(45, new Collaborator(45).value);
assertEquals(20, c3.getId());  //it works now