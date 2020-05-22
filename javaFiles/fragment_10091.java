USBDeviceDetectorManager manager = new USBDeviceDetectorManager();
List<USBStorageDevice> usbStorageDevices = manager.getRemovableDevices();

for(USBStorageDevice usbStorageDevice : usbStorageDevices)
{
    System.out.println(usbStorageDevice.getSystemDisplayName());
    System.out.println(usbStorageDevice.getDeviceName());
    System.out.println(usbStorageDevice.getRootDirectory());
}