@SyncanoClass(name = "custom_obj")
public class CustomObj extends SyncanoObject {
    public static final String FIELD_TITLEID = "title";
    public static final String FIELD_USERID = "userid";

    @SyncanoField(name = FIELD_TITLEID)
    public String title;
    @SyncanoField(name = FIELD_USERID)
    public YourSyncanoObject syncanoObject;
}