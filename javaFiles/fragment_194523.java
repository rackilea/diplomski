public interface OfferDetailsPdfMvp {

    interface View extends OfferDetailsView  {

        public void openLocalPdfFile(File file, int pageNumber);

    }

    interface Presenter<T extends MvpView> extends OfferDetailsPresenter<T> {

        public void onPageScrolled(int page, int pageCount);

    }
}