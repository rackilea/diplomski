public class Device extends Entity {
  @Expose @SerializedName("id")
  String deviceId;
   @Expose @SerializedName("device_id")
  String devicePushId;
  @Expose @SerializedName("device_type")
  String deviceType;
}