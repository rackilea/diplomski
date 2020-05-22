@Module
public class ServerModule {

    @Provides
    @Named("audio")
    @Singleton
    public Server provideAudioServer() {
        return new AudioServer();
    }

    @Provides
    @Named("video")
    @Singleton
    public Server provideVideoServer() {
        return new VideoServer();
    }
}