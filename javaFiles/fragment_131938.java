public class GetChallengeList {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("serverTime")
    @Expose
    private String serverTime;
    @SerializedName("expireTime")
    @Expose
    private String expireTime;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public GetChallengeList(String tokens, String expireTimes, String serverTimes){
        token = tokens;
        expireTime = expireTimes;
        serverTime = serverTimes;
    }
}