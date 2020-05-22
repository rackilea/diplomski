private static class MyUserDetails extends MyUser implements UserDetails {
    public MyUserDetails(MyUser myUser) {
        super(myUser);
    }

    // ... implement UserDetails methods

}