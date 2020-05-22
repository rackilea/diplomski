@RequestMapping(value="/receiveUpdatedStressScore")
public @ResponseBody Device receiveUpdatedStressScore(@RequestParam(value="value") int value,@RequestParam(value="device_model") String deviceModel)

{ 
    Device device = new Device();
    device.setDeviceModel(deviceModel);
    device.setValue(value);
    return device; 
}

public class Device {
    int value;
    String deviceModel;
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public String getDeviceModel() {
        return deviceModel;
    }
    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

}