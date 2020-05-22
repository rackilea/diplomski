public class MyFragment extends Fragment {

    @Inject
    Presenter<FwView> mHomePresenter;

    public void onCreate(Bundle xxx) {
        // simplified. Add your modules / Singleton component
        PresenterComponent component = DaggerPresenterComponent.create().inject(this);
    }
}