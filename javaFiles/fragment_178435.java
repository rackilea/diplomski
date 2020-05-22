@Module(injects = {MainActivity.class})
public class AppModule {

    private MyApplication application;

    public AppModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    public ImageAssistant provideImageAssistant() {
        return new ImageAssistantImpl(application); // implementation of ImageAssistant
    }

}