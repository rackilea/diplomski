@Test
public void testAddUser(){

    // prepare data
    User u = new User();
    u.setUserName("x");
    u.setPass("y");

    // expectation section
    mockDAO.addUser(u);
    EasyMock.expectLastCall();
    EasyMock.expect(mockDAO.checkUser(u)).andReturn(true);

    EasyMock.replay(mockDAO);

    // scenario
    service.registration(u);

    // verification
    EasyMock.verify(mockDAO);

}