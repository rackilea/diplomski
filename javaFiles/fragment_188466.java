String YOUR_DEVICE_NAME;
byte[] DATA;
int TIMEOUT;

USBManager manager = getApplicationContext().getSystemService(Context.USB_SERVICE);
Map<String, USBDevice> devices = manager.getDeviceList();
USBDevice mDevice = devices.get(YOUR_DEVICE_NAME);
USBDeviceConnection connection = manager.openDevice(mDevice);
USBEndpoint endpoint = device.getInterface(0).getEndpoint(0);

connection.claimInterface(device.getInterface(0), true);
connection.bulkTransfer(endpoint, DATA, DATA.length, TIMEOUT);