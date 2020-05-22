@Module
public class TabActivityModule {

    private final TabActivity activity;

    public TabActivityModule(TabActivity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    FragmentManager fragmentManager() {
        return activity.getFragmentManager(); 
    }
}