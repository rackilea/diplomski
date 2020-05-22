public class Details {
    private String message;
    private String status;
    private Map<String, List<UserDetails>> users = new HashMap<String, List<UserDetails>>();
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Map<String, List<UserDetails>> getUsers() {
        return users;
    }
    public void setUsers(Map<String, List<UserDetails>> users) {
        this.users = users;
    }
}