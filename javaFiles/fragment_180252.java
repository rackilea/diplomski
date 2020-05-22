newListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String address = mDevicesAdatper.getItem(position);
        BluetoothDevice btDevice = mBluetoothAdapter.getRemoteDevice(address);

        // TODO: Pair

    }
});