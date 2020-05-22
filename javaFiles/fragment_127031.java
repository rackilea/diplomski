enumComm = CommPortIdentifier.getPortIdentifiers();
while(enumComm.hasMoreElements()) {
    serialPortId = (CommPortIdentifier) enumComm.nextElement();
    if (serialPortId.getName().equalsIgnoreCase("/dev/ttyS1")) { //HERE you get your serial port

        try {
            SerialPort sp = (SerialPort) id.open("SerialExample", 30);
            //continue with your code here
        } catch (PortInUseException e) {
            System.out.println("port in use");
        }
    }
}