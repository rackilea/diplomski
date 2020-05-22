public class Travel {

    private Integer travelTime;
    private Integer totalDistance;
    private Integer pace;
    private Integer kCalBurned;
    private LinkedList<LatLng> latlng;

    public Integer getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(Integer travelTime) {
        this.travelTime = travelTime;
    }

    public Integer getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Integer totalDistance) {
        this.totalDistance = totalDistance;
    }

    public Integer getPace() {
        return pace;
    }

    public void setPace(Integer pace) {
        this.pace = pace;
    }

    public Integer getKCalBurned() {
        return kCalBurned;
    }

    public void setKCalBurned(Integer kCalBurned) {
        this.kCalBurned = kCalBurned;
    }

    public LinkedList<LatLng> getLatlng() {
        return latlng;
    }

    public void setLatlng(LinkedList<LatLng> latlng) {
        this.latlng = latlng;
    }

}