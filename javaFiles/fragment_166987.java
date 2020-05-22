@JsonIgnoreProperties(ignoreUnknown = true)
public class MainTracking implements Serializable {

    private Tracking Tracking;

    public String getTracking() {
        return tracking;
    }

    public void setTracking(Tracking tracking) {
        this.tracking = tracking;
    }
}



@JsonIgnoreProperties(ignoreUnknown = true)
public class Tracking implements Serializable {

    private String tracking_number;

    public Tracking() {
    }    

    public Tracking(String tracking_number) {
        setTracking_number(tracking_number);
    }    

    public String getTracking_number() {
        return tracking_number;
    }

    public void setTracking_number(String tracking_number) {
        this.tracking_number = tracking_number;
    }
}