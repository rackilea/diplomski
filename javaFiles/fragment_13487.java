@Module
public class SharedPreferencesModule {

    @Provides
    @Named("default")
    SharedPreferences provideDefaultsharedPreferences(Musician musician) {
        return musician.getSharedPreferences("default", Context.MODE_PRIVATE);
    }

    @Provides
    @Named("secret")
    SharedPreferences provideSecretsharedPreferences(Musician musician) {
        return musician.getSharedPreferences("secret", Context.MODE_PRIVATE);
    }
}