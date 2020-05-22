@Module
    public class PresenterModule {

        MainView mainView;

        public PresenterModule(MainView mainView) {
            this.mainView = mainView;
        }

        @Provides
        MainPresenter provideMainPresenter() {
            return new MainPresenter(mainView);
        }

    }