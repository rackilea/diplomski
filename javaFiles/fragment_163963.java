public interface CallBackPresenter {
  public void success(DataModel model);

  public void showError(String error);

  public void showLoader();

  public void hideLoader();

}