public class DashboardPresenterImpl implements DashboardPresenter {

    private ApiManager apiManager;
    private FragmentDashboardBinding fragmentBinding;
    private LoginFactory loginFactory;
    private LoginView loginView;
    private ViewHelper viewHelper;

    @Inject
    public DashboardPresenterImpl(ApiManager apiManager, LoginFactory loginFactory, LoginView loginView, ViewHelper viewHelper) {
        this.apiManager = apiManager;
        this.loginFactory = loginFactory;
        this.loginView = loginView;
        this.viewHelper = viewHelper;
    }
}