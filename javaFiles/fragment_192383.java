public class SPInfo {
    private String name;
    private boolean connected;
    private String permissions;
    private String URL;

    public SPInfo(String name, boolean isConnected, String permissions, String URL) {
        super();
        this.name = name;
        this.connected = isConnected;
        this.permissions = permissions;
        this.URL = URL;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isConnected() {
        return connected;
    }
    public void setConnected(boolean isConnected) {
        this.connected = isConnected;
    }
    public String getPermissions() {
        return permissions;
    }
   public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
    public String getURL() {
        return URL;
    }
    public void setURL(String uRL) {
        URL = uRL;
    }   
}