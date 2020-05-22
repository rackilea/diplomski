@Module
public class MyAppModule {
    //...
    @Provides
    @Singleton
    public UserHolder userHolder(User user) {
         UserHolder userHolder = new UserHolder();
         userHolder.setUser(user);
         return userHolder;
    }

    @Provides
    @Singleton
    public User user() {
         return new User();
    }
}