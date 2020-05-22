public abstract class YourClass {
  protected abstract void addInfoMessage(String message);
  protected abstract void addErrorMessage(String message);

  public void closeTransaction() {
    try {
      saveAccountInternal();                                                /* ! */
      addInfoMessage("All Updated!");
    } catch (final ResourceException e) {
      addErrorMessage("Sorry your account could not be updated.");
    }
    return null;
  }

  /** Package-private. Overridable for testing. */
  void saveAccountInternal() throws ResourceException {
    account.save();
  }
}