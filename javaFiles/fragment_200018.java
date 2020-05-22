public class WalkServiceImpl {
    @Autowired
    private VehicleProperties vehicleProperties;

    @Override
    public void performTask(VehicleData vehicleData) {
        ...
        VehicleUtil.checkBatteryStatus(vehicleProperties, vehicleData);
    }
}