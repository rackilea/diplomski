package ...;

import javax.inject.Singleton;
import dagger.Component;
import dagger.MembersInjector;

@Singleton
@Component(modules = { PlaygroundModule.class })
public interface MainComponent {
    Wizard createWizard();
    MembersInjector<MainActivity> mainActivityInjector();
}