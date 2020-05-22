public class ImageRequest{
    public static final ImageRequest DEFAULT_BODY;
    public static final String DEFAULT_JSON_BODY;

    static {
        DEFAULT_BODY = new ImageRequest();
        DEFAULT_BODY.setAndroidId("15df3b3a90dc5688");
        DEFAULT_BODY.setContentId("704");
        DEFAULT_BODY.setFrame("1");
        DEFAULT_BODY.setPassword("BandarAndroid");
        DEFAULT_BODY.setUserName("ApiService");

        DEFAULT_JSON_BODY = new Gson().toJson(DEFAULT_BODY, ImageRequest.class);
    }

    @SerializedName("UserName")
    private String userName;
    @SerializedName("ContentId")
    private String contentId;
    @SerializedName("AndroidId")
    private String androidId;
    @SerializedName("Password")
    private String password;
    @SerializedName("frame")
    private String frame;

    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setContentId(String contentId){
        this.contentId = contentId;
    }
    public void setAndroidId(String androidId){
        this.androidId = androidId;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setFrame(String frame){
        this.frame = frame;
    }
}