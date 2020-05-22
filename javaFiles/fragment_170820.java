public void addDevice(String name, int port){
    Device temp = new Device();
    temp.setPort(port);
    temp.setName(name);
    allDevices.put(""+lastId,temp); <-- Note that lastId is an integer
    this.lastId++;
    Global.dbMRoot.child("devicesController").child("devices").child(""+lastId).setValue(allDevices.get(lastId));
}