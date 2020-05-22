public class ProductViewBean {
  private final Product delegate;

  public ProductViewBean(Product delegate) {
    this.delegate = delegate;
  }

  Product getDelegate() {
    return delegate;
  }

  public String getTitle() {
    if (delegate.getTitle == null) {
      return delegate.getName() + " - " + delegate.getCategory();
    }
    return delegate.getTitle();
  }

  public void setTitle(String title) {
    delegate.setTitle(title);
  }

  public boolean isDeleted() {
    return delegate.getDeleted() == 1L;
  }

  public void setDeleted(boolean deleted) {
    delegate.setDeleted(deleted ? 1L : 0L);
  }

  ...
}