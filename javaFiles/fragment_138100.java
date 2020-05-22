@Module
public class YourModule {

    private Context context;

    public YourModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    final Context providesContext() {
        return context;
    }
}