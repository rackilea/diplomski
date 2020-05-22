public final class SaveSystemSingleton {
  // This class should only be accessed statically. Don't allow instance creation
  private SaveSystemSingelton() {}

  private static SaveSystem saveSystem;

  // Encapsulate creation logic. Passing in params is misleading because
  // all subsequent calls will do nothing with the params.
  public static SaveSystem get() {
    // If accessing from multiple threads do Double Check Locking instead!
    if (saveSystem == null) {
      saveSystem = new SaveSystem(new FirebaseAuth(), new LoadProjFragment());
    }
    return saveSystem;
  }
}