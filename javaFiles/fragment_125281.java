package ...;

// other imports
import javax.inject.Inject;
import dagger.MembersInjector;

public class MainActivity extends ActionBarActivity {

    @Inject
    Wizard wizard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainComponent c = DaggerMainComponent.create();
        c.mainActivityInjector().injectMembers(this);

        // other code...
    }
}