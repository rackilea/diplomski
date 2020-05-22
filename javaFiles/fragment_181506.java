@UiField CommonBundle res;

public LoadingScreen() {
    initWidget(uiBinder.createAndBindUi(this));
    res.centerStyle().ensureInjected();
}