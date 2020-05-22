Entity(tableName = "realtime_data")
public class RealTimeData {

    @PrimaryKey
    @NonNull
    private String id;

    @ColumnInfo(name = "json_data")
    private String jsonData;

    @ColumnInfo(name = "is_sent")
    private boolean isSent;

    @ColumnInfo(name = "device_id")
    private String deviceId;

    @ColumnInfo(name = "date_created")
    private Date dateCreated;

    @Ignore
    RealTimeData(@NonNull final String jsonData, @NonNull final Date dateCreated) {
        id = UUID.randomUUID().toString();
        this.jsonData = jsonData;
        this.dateCreated = dateCreated;
    }

    RealTimeData(@Nonnull final String id, final String jsonData, final Date dateCreated) {
        this.id = id;
        this.jsonData = jsonData;
        this.dateCreated = dateCreated;
    }

    String getJsonData() {
        return jsonData;
    }

    @Nonnull
    public String getId() {
        return id;
    }

    public boolean isSent() {
        return isSent;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setSent(final boolean sent) {
        isSent = sent;
    }

    public void setDeviceId(final String deviceId) {
        this.deviceId = deviceId;
    }
}