private String ipAddress;
private String portNo;
private Socket networkSocket;

protected NetworkInformation(Parcel in) {
      ipAddress = in.readString();
      portNo = in.readString();
      networkSocket = new Socket(makeRealIP(ipAddress),makeRealPortNo(portNo));
}