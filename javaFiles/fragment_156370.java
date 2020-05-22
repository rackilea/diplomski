@Module
public class AppModule {
    private final B listener;

    public AppModule(B listener) {
        this.listener = listener;
    }

    @Provides
    B provideListener() {
        return listener;
    }

    @Provides
    C provideC(B listener) {
        return new C(listener);
    }

    @Provides
    D provideD(B listener) {
        return new D(listener);
    }
}