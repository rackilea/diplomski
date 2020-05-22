public void shouldReturn5WhenAdding2And3 {
  // When
  int result = testSubject.add(2, 3);       

  // Then
  assertEquals(result, 5);
}