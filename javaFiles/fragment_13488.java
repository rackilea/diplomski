@Module
public class MusicianModule {

    private Musician musician;

    public MusicianModule(Musician musician) {
        this.musician = musician;
    }

    @Provides @Singleton
    Musician providemusician() {
        return musician;
    }

    @Provides @Singleton
    Application provideapplication(Musician musician) {
        return musician;
    }
}