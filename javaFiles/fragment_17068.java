public void testGetUser() {
    User user = new User("Bob","bob87);
    user.setId("bob87"); //username is the id

    EasyMock.expect(userRepositoryMock.get(user.getId()))
            .andReturn(user); 
    EasyMock.expectLastCall().times(1);
    EasyMock.replay(userRepositoryMock);

    userService.getUser(user.getId());

    EasyMock.verify(userRepositoryMock);
}