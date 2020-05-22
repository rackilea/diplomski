@Module
public class HomeFragmentModule {
    @Provides
    @Named("HomeFragment")
    ViewModelProvider.Factory provideHomeFragmentViewModel(HomeFragmentViewModel homeFragmentViewModel) {
        return new ViewModelProviderFactory<>(homeFragmentViewModel);
    }
    /* Rest of the code */
}

public class HomeFragment {
    @Inject
    @Named("HomeFragment")
    ViewModelProvider.Factory mViewModelFactory;
    /* Rest of the code */
}