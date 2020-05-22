public class VehicleInfoManager {
    private static VehicleInfoManager INSTANCE = new VehicleInfoManager();

    private VehicleInfo currentVehicleInfo;

    public static VehicleInfoManager getInstance() {
        return INSTANCE;
    }

    public void setCurrentVehicleInfo(VehicleInfo info) {
        this.currentVehicleInfo = info;
    }

    public String getVehicleEnginePower() {
        return this.currentVehicleInfo.getVehicleEnginePower();
    }

    private VehicleInfoManager() {
        // Constructor private by default
    }
}