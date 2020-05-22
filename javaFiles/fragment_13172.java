//get local host
InetAddress localHost = InetAddress.getLocalHost();

//make a List to hold the sockets
//we know how many there will be so use that capacity
List<DatagramSocket> datagramSockets =
        new ArrayList<DatagramSocket>(portList.size());

//for each port,
for (Integer port : portList) {
    //instantiate a new socket
    DatagramSocket datagramSocket = new DatagramSocket();
    //add it to the list
    datagramSockets.add(datagramSocket);
    //connect it using the port
    datagramSocket.connect(localHost, port);
}