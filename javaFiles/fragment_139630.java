private void pairedDevicesList(View dialogView)
{
    pairedDevices = myBluetooth.getBondedDevices();
    ArrayList list = new ArrayList();
    devicelist = (ListView) dialogView.findViewById(R.id.listDevicesDialog); 
...
}
// show the dialog for connected devices
private void showDialog()
{
    AlertDialog.Builder mBuilder = new AlertDialog.Builder(DeviceList.this);
    View mView = getLayoutInflater().inflate(R.layout.device_dialog, null);
    mBuilder.setView(mView);
    AlertDialog dialog = mBuilder.create();
    dialog.show();
    pairedDevicesList(mView);
}