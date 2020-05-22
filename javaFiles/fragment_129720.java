private class TestUserManagerFactory implements UserManagerFactory {

    @Override
    public UserManager createUserManager() {
        return new TestUserManager("admin", new ClearTextPasswordEncryptor());
    }
}

private class TestUserManager extends AbstractUserManager {
    private BaseUser testUser;
    private BaseUser anonUser;

    public TestUserManager(String adminName, PasswordEncryptor passwordEncryptor) {
        super(adminName, passwordEncryptor);

        testUser = new BaseUser();
        testUser.setAuthorities(Arrays.asList(new Authority[] {new ConcurrentLoginPermission(1, 1)}));
        testUser.setEnabled(true);
        testUser.setHomeDirectory(TEST_USER_FTP_ROOT);
        testUser.setMaxIdleTime(10000);
        testUser.setName(TEST_USERNAME);
        testUser.setPassword(TEST_PASSWORD);

        anonUser = new BaseUser(testUser);
        anonUser.setName("anonymous");
    }

    @Override
    public User getUserByName(String username) throws FtpException {
        if(TEST_USERNAME.equals(username)) {
            return testUser;
        } else if(anonUser.getName().equals(username)) {
            return anonUser;
        }

        return null;
    }

    @Override
    public String[] getAllUserNames() throws FtpException {
        return new String[] {TEST_USERNAME, anonUser.getName()};
    }

    @Override
    public void delete(String username) throws FtpException {
        //no opt
    }

    @Override
    public void save(User user) throws FtpException {
        //no opt
        System.out.println("save");
    }

    @Override
    public boolean doesExist(String username) throws FtpException {
        return (TEST_USERNAME.equals(username) || anonUser.getName().equals(username)) ? true : false;
    }

    @Override
    public User authenticate(Authentication authentication) throws AuthenticationFailedException {
        if(UsernamePasswordAuthentication.class.isAssignableFrom(authentication.getClass())) {
            UsernamePasswordAuthentication upAuth = (UsernamePasswordAuthentication) authentication;

            if(TEST_USERNAME.equals(upAuth.getUsername()) && TEST_PASSWORD.equals(upAuth.getPassword())) {
                return testUser;
            }

            if(anonUser.getName().equals(upAuth.getUsername())) {
                return anonUser;
            }
        } else if(AnonymousAuthentication.class.isAssignableFrom(authentication.getClass())) {
            return anonUser;
        }

        return null;
    }
}