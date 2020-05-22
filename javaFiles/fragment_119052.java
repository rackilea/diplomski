public class Device {

    @SerializedName("id")
    public String id;

    @SerializedName("name.en_US")
    public String en;

    @SerializedName("name.fi_FI")
    public String fi;

    public Device(String id, String english, String fi) {
        this.id = id;
        this.en = english;
        this.fi = fi;
     }
    //Getters and setters
}