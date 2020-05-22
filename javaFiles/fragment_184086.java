@Test
public void testFindUserByName() {

    // given
    SetOfUsers instance = new SetOfUsers();

    // when
    User result = instance.findUserByName("Bob");

    // then
    assertEquals("Bob", result.getName());

}