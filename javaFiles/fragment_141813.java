@JsonDeserialize(using = UsersResponseDeserializer.class)
class UsersResponse {

    private Map<Integer, Map<String, String>> users;

    public Map<Integer, Map<String, String>> getUsers() {
        return users;
    }

    public void setUsers(Map<Integer, Map<String, String>> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UsersResponse{" +
                "users=" + users +
                '}';
    }
}