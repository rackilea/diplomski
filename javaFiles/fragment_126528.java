@Test
public void testFooGivesNotNull() {
  assertNotNull(foo.bar(somethingLeadingToNotNull));
}

@Test
public void testFooGivesNull() {
  assertNull(foo.bar(somethingElseLeadingToNull));
}