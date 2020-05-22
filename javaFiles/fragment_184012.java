@Module
public class MainModule {

    @Provides
    public static LoginFragment provideLoginFragment() {
        return LoginFragment.newInstance("param1", "param2");
    }

}