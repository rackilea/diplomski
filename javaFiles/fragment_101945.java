Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
if(pairedDevices.size() > 0)
{
    for(BluetoothDevice device : pairedDevices)
    {
        if(device.getName().equals("Hauwa")) 
        {
            mmDevice = device;
            break;
        }
    }
}