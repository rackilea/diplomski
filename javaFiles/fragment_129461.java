private class Demo implements UserDetailsChecker {
    public void check(UserDetails user) {
        if (!user.isAccountNonLocked())
            throw new LockedException("User account is locked");
        if (!user.isEnabled())
            throw new DisabledException("User is disabled"));
        if (!user.isAccountNonExpired())
            throw new AccountExpiredException("User account has expired");
        //And here comes you!
    }
}