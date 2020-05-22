@Singleton
@Component(modules = {MusicianModule.class, SharedPreferencesModule.class})
public interface MusicianComponent {
    void inject(MainActivity mainActivity);
    Musician musician();
}