public class DrivingDetails {

    private double startKM;
    private double endKM;
    private String startLocation;
    private String endLocation;

    public DrivingDetails(double startKM, double endKM, String startLocation, String endLocation) {
        this.startKM = startKM;
        this.endKM = endKM;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
    }

    public double getStartKM() {
        return startKM;
    }
    public void setStartKM(double startKM) {
        this.startKM = startKM;
    }

    // rest of the methods left for you ...
}