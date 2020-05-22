public class Musician extends Application {

    private MusicianComponent musicianComponent;
    @Override
    public void onCreate() {
        resolvedependency();
        super.onCreate();
    }


    private void resolvedependency() {
        musicianComponent = DaggerMusicianComponent.builder()
                .musicianModule(new MusicianModule(this))
                .sharedPreferencesModule(new SharedPreferencesModule())
                .build();
    }


    public static MusicianComponent getMusicianComponent(Context context) {
        return ((Musician)context.getApplicationContext()).musicianComponent;
    }
}