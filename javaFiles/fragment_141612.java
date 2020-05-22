public class SFTPLoginCredentials {
    private final String host;
    private final int port;
    private final String rootDirectory;
    private final String username;
    private final String password;
    // Add a constructor and getters for all these instance variables
}
public static class SFTPUtils {
    public static void deleteFile(String filename, SFTPLoginCredentials credentials);
    public static void uploadFile(InputStream data, String filename, SFTPLoginCredentials credentials);
    public static void downloadFile(String filename, OutputStream data, SFTPLoginCredentials credentials);
}