@Test
public void addWrongNewUserSpaceInUsername() throws Exception {

    // inject the mock in the class under test
    UserController userController = new UserController(new UserValidatorStub(user.getUsername(), false));
    try {
        userController.createUser(user);
    } catch (Exception e) {
        Assert.assertTrue(e.getCause() instanceof UsernameNotValidException);
    }
}