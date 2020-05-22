public class Session {
    private String currentUserId = null;
    public void setCurrentUserId( String id ) {
        currentUserId = id;
    }
    public String getCurrentUserId() {
        return currentUserId;
    }
    // Other session related information
    //... 
}