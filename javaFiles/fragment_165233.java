public class FriendsResposne implements Serializable {
    @SerializedName("status")
    private String status;
    @SerializedName("messae")
    private String message;
    @SerializedName("friends")
    private List< Friend_Request_adapter > friendsArr;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Friend_Request_adapter> getFriendsArr() {
        return friendsArr;
    }

    public void setFriendsArr(List<Friend_Request_adapter> friendsArr) {
        this.friendsArr = friendsArr;
    }
}