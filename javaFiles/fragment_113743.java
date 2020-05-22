public class HostPageUtils {
  private static final native String getSerializedUser() /*-{
        return $wnd.serialized_user;
  }-*/;

  public static User getUser() {
    final String serializedUser = getSerializedUser();
    StorageSerializer storageSerializer = GWT.create(StorageSerializer.class);
    try {
      return storageSerializer.deserialize(User.class, serializedUser);
    } catch (Exception e) {
      throw new RuntimeException();
    }
  }
}