@OnApplicationStartup
public class ExtinguisherBootstrap extends Job { 
    public void doJob() {
        new Extinguisher()
            .every(Play.configuration.getProperty("my.setting", "10s"));
    }
}