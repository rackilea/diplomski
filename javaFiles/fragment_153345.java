package com.marcoferraioli.loopback;

public class UserRepository extends com.strongloop.android.loopback.UserRepository<User> {

    public interface LoginCallback extends com.strongloop.android.loopback.UserRepository.LoginCallback<User> {
        }

    public UserRepository() {
        super("user", null, User.class);
    }

}