public class Devices {

@Expose
private List<Device> devices = new ArrayList<Device>();

/**
* 
* @return
* The devices
*/
public List<Device> getDevices() {
return devices;
}

/**
* 
* @param devices
* The devices
*/
public void setDevices(List<Device> devices) {
this.devices = devices;
}

}