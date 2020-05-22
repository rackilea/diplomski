@Test
public void testExistingUser() {
    UserDao mockUserDao = mock(UserDao.class);
    when(mockUserDao.getExistingUser()).thenReturn(getExistingTestUser());

    CheckUser checkUser = new CheckUser(mockUserDao);
    IUser iUser = checkUser.getExistingUser();

    // assertions here
}

private UserDao getExistingTestUser(() {
    return ExistingUserImpl.Builder(). //withfield methods. build();
}