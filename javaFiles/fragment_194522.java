public interface OfferDetailsPresenter<T extends MvpView> extends MvpPresenter<T> {

    void downloadToAppDir(boolean isDownloadToAppCacheDir);

    void onClickScreen(boolean isVisibleTopContainer);
}