@Singleton
@Component(modules = { AppModule.class, UtilityModule.class })
public interface MainComponent {

    ReceiversComponent withReceiversModule(); // Here is the reference to the subcomponent with abstract module

    void inject(MainActivity activity);
}