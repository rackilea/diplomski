@Module
public class AppModules {
    private Context context;

    public AppModules(Context context) {
        this.context = context;
    }

    @Provides // this can be non-scoped because anyway the same instance is always returned
    Context provideContext() {
        return this.context;
    }

    @Provides
    @Singleton
    SP provideSharePreferences(Context context) {
        return new SP(context); // use method-local Context
    }
}